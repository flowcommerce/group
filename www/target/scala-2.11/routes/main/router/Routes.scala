
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mikeroth/GitRepos/group/www/conf/routes
// @DATE:Mon Jan 11 11:38:15 EST 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.io.flow.group.v0.Bindables._

object Routes extends Routes

class Routes extends GeneratedRouter {

  import ReverseRouteContext.empty

  override val errorHandler: play.api.http.HttpErrorHandler = play.api.http.LazyHttpErrorHandler

  private var _prefix = "/"

  def withPrefix(prefix: String): Routes = {
    _prefix = prefix
    router.RoutesPrefix.setPrefix(prefix)
    
    this
  }

  def prefix: String = _prefix

  lazy val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation: Seq[(String, String, String)] = List(
    ("""GET""", prefix, """controllers.ApplicationController.index()"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """_internal_/healthcheck""", """controllers.HealthchecksController.index()"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    ("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """webjars/$file<.+>""", """controllers.WebJarAssets.at(file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  private[this] lazy val controllers_ApplicationController_index0_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_ApplicationController_index0_invoker = createInvoker(
    controllers.ApplicationController.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "index",
      Nil,
      "GET",
      """""",
      this.prefix + """"""
    )
  )

  // @LINE:2
  private[this] lazy val controllers_HealthchecksController_index1_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("_internal_/healthcheck")))
  )
  private[this] lazy val controllers_HealthchecksController_index1_invoker = createInvoker(
    controllers.HealthchecksController.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HealthchecksController",
      "index",
      Nil,
      "GET",
      """""",
      this.prefix + """_internal_/healthcheck"""
    )
  )

  // @LINE:6
  private[this] lazy val controllers_Assets_at2_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at2_invoker = createInvoker(
    controllers.Assets.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/$file<.+>"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_WebJarAssets_at3_route: Route.ParamsExtractor = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("webjars/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_WebJarAssets_at3_invoker = createInvoker(
    controllers.WebJarAssets.at(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WebJarAssets",
      "at",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """webjars/$file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case controllers_ApplicationController_index0_route(params) =>
      call { 
        controllers_ApplicationController_index0_invoker.call(controllers.ApplicationController.index())
      }
  
    // @LINE:2
    case controllers_HealthchecksController_index1_route(params) =>
      call { 
        controllers_HealthchecksController_index1_invoker.call(controllers.HealthchecksController.index())
      }
  
    // @LINE:6
    case controllers_Assets_at2_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at2_invoker.call(controllers.Assets.at(path, file))
      }
  
    // @LINE:7
    case controllers_WebJarAssets_at3_route(params) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_WebJarAssets_at3_invoker.call(controllers.WebJarAssets.at(file))
      }
  }
}