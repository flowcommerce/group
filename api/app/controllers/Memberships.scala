package controllers

import db.MembershipsDao
import io.flow.common.v0.models.User
import io.flow.group.v0.models.{UserReference, Membership, User}
import io.flow.group.v0.models.json._
import io.flow.play.clients.UserTokensClient
import io.flow.play.controllers.IdentifiedRestController
import io.flow.postgresql.OrderBy
import io.flow.play.util.{Expander, Validation}
import io.flow.common.v0.models.json._
import io.flow.user.v0.interfaces.Client
import play.api.libs.json
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.json.Json
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.ExecutionContext.Implicits.global


class Memberships @javax.inject.Inject() (
  val userTokensClient: UserTokensClient,
  val usersClient: Client,
  val userClient: clients.User
  ) extends Controller
  with IdentifiedRestController {


  override def expanders = {
    Seq(new io.flow.play.expanders.User("user", userClient.client))
  }

  def get(
   id: Option[Seq[String]],
   limit: Long = 25,
   offset: Long = 0,
   sort: String,
   expand: Option[Seq[String]]
  ) = Identified { request =>
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