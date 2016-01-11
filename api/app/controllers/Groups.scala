package controllers

import db.{GroupsDao}
import io.flow.group.v0.models.{Group}
import io.flow.group.v0.models.json._
import io.flow.play.clients.{UserTokensClient, AuthorizationClient}
import io.flow.play.controllers.AuthorizedRestController
import io.flow.postgresql.{Query, OrderBy}
import io.flow.play.util.Validation
import io.flow.common.v0.models.json._
import play.api.mvc._
import play.api.libs.json._


class Groups @javax.inject.Inject() (
  val userTokensClient: UserTokensClient,
  val authorizationClient: AuthorizationClient
  ) extends Controller
with AuthorizedRestController {

  def get(
           id: Option[Seq[String]],
           limit: Long = 25,
           offset: Long = 0,
           sort: String
         ) = Authenticated(
    reads = Some("io.flow.groups")
  ) { request =>
    println("ASDf")
    OrderBy.parse(sort) match {
      case Left(errors) => {
        UnprocessableEntity(Json.toJson(Validation.invalidSort(errors)))
      }
      case Right(orderBy) => {
        println("asdf")
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