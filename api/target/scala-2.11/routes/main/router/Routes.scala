
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mikeroth/GitRepos/group/api/conf/routes
// @DATE:Mon Jan 11 15:11:43 EST 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.io.flow.group.v0.Bindables._

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  Groups_0: controllers.Groups,
  // @LINE:7
  Healthchecks_1: controllers.Healthchecks,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    Groups_0: controllers.Groups,
    // @LINE:7
    Healthchecks_1: controllers.Healthchecks
  ) = this(errorHandler, Groups_0, Healthchecks_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Groups_0, Healthchecks_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """groups""", """controllers.Groups.get(id:_root_.scala.Option[List[String]], limit:Long ?= 25, offset:Long ?= 0, sort:String ?= "lower(name),-created_at")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """_internal_/healthcheck""", """controllers.Healthchecks.getInternalAndHealthcheck()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_Groups_get0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("groups")))
  )
  private[this] lazy val controllers_Groups_get0_invoker = createInvoker(
    Groups_0.get(fakeValue[_root_.scala.Option[List[String]]], fakeValue[Long], fakeValue[Long], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Groups",
      "get",
      Seq(classOf[_root_.scala.Option[List[String]]], classOf[Long], classOf[Long], classOf[String]),
      "GET",
      """""",
      this.prefix + """groups"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_Healthchecks_getInternalAndHealthcheck1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("_internal_/healthcheck")))
  )
  private[this] lazy val controllers_Healthchecks_getInternalAndHealthcheck1_invoker = createInvoker(
    Healthchecks_1.getInternalAndHealthcheck(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Healthchecks",
      "getInternalAndHealthcheck",
      Nil,
      "GET",
      """GET     /groups/versions            controllers.Groups.getVersions(id: _root_.scala.Option[List[String]], group_id: _root_.scala.Option[List[String]], limit: Long ?= 25, offset: Long ?= 0, sort: String ?= "created_at")""",
      this.prefix + """_internal_/healthcheck"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case controllers_Groups_get0_route(params) =>
      call(params.fromQuery[_root_.scala.Option[List[String]]]("id", None), params.fromQuery[Long]("limit", Some(25)), params.fromQuery[Long]("offset", Some(0)), params.fromQuery[String]("sort", Some("lower(name),-created_at"))) { (id, limit, offset, sort) =>
        controllers_Groups_get0_invoker.call(Groups_0.get(id, limit, offset, sort))
      }
  
    // @LINE:7
    case controllers_Healthchecks_getInternalAndHealthcheck1_route(params) =>
      call { 
        controllers_Healthchecks_getInternalAndHealthcheck1_invoker.call(Healthchecks_1.getInternalAndHealthcheck())
      }
  }
}