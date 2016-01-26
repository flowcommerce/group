package controllers

import db.MembershipsDao
import io.flow.common.v0.models.User
import io.flow.group.v0.models.{UserReference, Membership, User}
import io.flow.group.v0.models.json._
import io.flow.play.clients.{UserTokensClient, AuthorizationClient}
import io.flow.play.controllers.AuthorizedRestController
import io.flow.postgresql.OrderBy
import io.flow.play.util.{Expander, Validation}
import io.flow.common.v0.models.json._
import io.flow.user.v0.Client
import play.api.libs.json
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.json.Json
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import io.flow.play.expanders.User


class Memberships @javax.inject.Inject() (
  val userTokensClient: UserTokensClient,
  val authorizationClient: AuthorizationClient
  ) extends Controller
  with AuthorizedRestController {

  override def expanders = {
    val userPort = 8001
    Seq(
      new io.flow.play.expanders.User(
        "user",
        new Client(s"http://localhost:$userPort", auth = Some(io.flow.user.v0.Authorization.Basic("test"))))
    )
  }

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
        MembershipsDao.findAll(ids = optionals(id),
          limit = limit,
          offset = offset,
          orderBy = orderBy) match {

          case Some(memberships) =>
            val membsAsJson = memberships.map(m => Json.toJson(m))

            Expansion.sync(expand, membsAsJson) { res =>
              Ok(res)
            }

          case None => Results.NotFound
        }
      }
    }
  }
}