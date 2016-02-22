package controllers

import db.GroupsDao
import io.flow.group.v0.models.json._
import io.flow.play.clients.UserTokensClient
import io.flow.play.controllers.IdentifiedRestController
import io.flow.postgresql.OrderBy
import io.flow.play.util.Validation
import io.flow.common.v0.models.json._
import io.flow.user.v0.interfaces.Client
import play.api.mvc._
import play.api.libs.json._


class Groups @javax.inject.Inject() (
  val userTokensClient: UserTokensClient,
  val usersClient: Client
  ) extends Controller
  with IdentifiedRestController {

  def get(
   id: Option[Seq[String]],
   limit: Long = 25,
   offset: Long = 0,
   sort: String
  ) = Identified { request =>
    OrderBy.parse(sort) match {
      case Left(errors) => {
        UnprocessableEntity(Json.toJson(Validation.invalidSort(errors)))
      }
      case Right(orderBy) => {
        Ok(
          Json.toJson(
            GroupsDao.findAll(
              ids = optionals(id),
              limit = limit,
              offset = offset,
              orderBy = orderBy
            )
          )
        )
      }
    }
  }
}