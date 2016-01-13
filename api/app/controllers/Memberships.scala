package controllers

import db.MembershipsDao
import io.flow.group.v0.models.{User, UserReference, Membership}
import io.flow.group.v0.models.json._
import io.flow.play.clients.{UserTokensClient, AuthorizationClient}
import io.flow.play.controllers.AuthorizedRestController
import io.flow.postgresql.OrderBy
import io.flow.play.util.Validation
import io.flow.common.v0.models.json._
import io.flow.user.v0.Client
import play.api.libs.json
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.json.Json
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.ExecutionContext.Implicits.global


class Memberships @javax.inject.Inject() (
  val userTokensClient: UserTokensClient,
  val authorizationClient: AuthorizationClient
  ) extends Controller
with AuthorizedRestController {

  private val port = 8001
  lazy val userClient = new Client(s"http://localhost:$port", auth = Some(io.flow.user.v0.Authorization.Basic("test")))

  trait Expander{
    def expand(records: Seq[JsValue])(implicit ec: ExecutionContext): Future[Seq[JsValue]]
  }

  case class UserExpander(
     fieldName: String,
     userClient: io.flow.user.v0.Client
  ) extends Expander {
    def expand(records: Seq[JsValue])(implicit ec: ExecutionContext): Future[Seq[JsValue]] = {
      //records is Seq[Memberships]]

      val userIds: Seq[String] = records.map { r =>
        (r \ fieldName).validate[UserReference] match {
          case JsSuccess(ur, _) => ur.id
        }
      }

      userIds match {
        case Nil => Future {
          records
        }
        case ids => {
          userClient.Users.get(id = Some(ids), limit = userIds.size).map(users =>
            Map(users.map(u => (u.id -> User(u.id, u.email))): _*)
          ).map(userIdLookup =>
            records.map { r =>
              r.validate[JsObject] match {
                case JsError(_) => r
                case JsSuccess(obj, _) => {
                  (r \ fieldName).validate[UserReference] match {
                    case JsSuccess(userReference, _) => {
                      obj ++ Json.obj(
                        fieldName -> Json.toJson(
                          userIdLookup.get(userReference.id).getOrElse(userReference)
                        )
                      )
                    }
                    case JsError(_) => r
                  }
                }
              }
            }
          )
        }
      }
    }
  }

  val expanders = Seq(
    new UserExpander("user", userClient)
  )



  def get(
   id: Option[Seq[String]],
   limit: Long = 25,
   offset: Long = 0,
   sort: String,
   expand: Option[Seq[String]]

  ) = Authenticated(
    reads = Some("io.flow.memberships")
  ) { request =>
    OrderBy.parse(sort) match {
      case Left(errors) => {
        UnprocessableEntity(Json.toJson(Validation.invalidSort(errors)))
      }
      case Right(orderBy) => {
        val memerships = MembershipsDao.findAll(ids = optionals(id),
          limit = limit,
          offset = offset,
          orderBy = orderBy).get.map(memb => //maybe don't use 'get', but match if we actually return an Option

          Json.toJson(memb)
        )

        Ok(Json.toJson(expanders.filter(e => expand.getOrElse(Nil).contains(e.fieldName)).foldLeft(memerships) { case (records, e) =>
          Await.result(e.expand(records), Duration(5, "seconds"))
        }))
      }
    }
  }
}