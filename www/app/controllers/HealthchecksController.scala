package controllers

import io.flow.group.v0.models.Healthcheck
import io.flow.group.v0.models.json._

import play.api._
import play.api.mvc._

object HealthchecksController extends Controller {

  def index() = Action { implicit request =>
    Ok(views.html.healthchecks.index("healthy"))
  }

}