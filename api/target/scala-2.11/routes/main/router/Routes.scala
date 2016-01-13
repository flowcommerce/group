
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mikeroth/GitRepos/group/api/conf/routes
// @DATE:Tue Jan 12 06:57:55 EST 2016

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
  Groups_1: controllers.Groups,
  // @LINE:7
  Healthchecks_2: controllers.Healthchecks,
  // @LINE:8
  Memberships_0: controllers.Memberships,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    Groups_1: controllers.Groups,
    // @LINE:7
    Healthchecks_2: controllers.Healthchecks,
    // @LINE:8
    Memberships_0: controllers.Memberships
  ) = this(errorHandler, Groups_1, Healthchecks_2, Memberships_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Groups_1, Healthchecks_2, Memberships_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """groups""", """controllers.Groups.get(id:_root_.scala.Option[List[String]], limit:Long ?= 25, offset:Long ?= 0, sort:String ?= "lower(name),-created_at")"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """_internal_/healthcheck""", """controllers.Healthchecks.getInternalAndHealthcheck()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """memberships""", """controllers.Memberships.get(id:_root_.scala.Option[List[String]], limit:Long ?= 25, offset:Long ?= 0, sort:String ?= "-created_at", expand:_root_.scala.Option[List[String]])"""),
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
    Groups_1.get(fakeValue[_root_.scala.Option[List[String]]], fakeValue[Long], fakeValue[Long], fakeValue[String]),
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
    Healthchecks_2.getInternalAndHealthcheck(),
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

  // @LINE:8
  private[this] lazy val controllers_Memberships_get2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("memberships")))
  )
  private[this] lazy val controllers_Memberships_get2_invoker = createInvoker(
    Memberships_0.get(fakeValue[_root_.scala.Option[List[String]]], fakeValue[Long], fakeValue[Long], fakeValue[String], fakeValue[_root_.scala.Option[List[String]]]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Memberships",
      "get",
      Seq(classOf[_root_.scala.Option[List[String]]], classOf[Long], classOf[Long], classOf[String], classOf[_root_.scala.Option[List[String]]]),
      "GET",
      """""",
      this.prefix + """memberships"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case controllers_Groups_get0_route(params) =>
      call(params.fromQuery[_root_.scala.Option[List[String]]]("id", None), params.fromQuery[Long]("limit", Some(25)), params.fromQuery[Long]("offset", Some(0)), params.fromQuery[String]("sort", Some("lower(name),-created_at"))) { (id, limit, offset, sort) =>
        controllers_Groups_get0_invoker.call(Groups_1.get(id, limit, offset, sort))
      }
  
    // @LINE:7
    case controllers_Healthchecks_getInternalAndHealthcheck1_route(params) =>
      call { 
        controllers_Healthchecks_getInternalAndHealthcheck1_invoker.call(Healthchecks_2.getInternalAndHealthcheck())
      }
  
    // @LINE:8
    case controllers_Memberships_get2_route(params) =>
      call(params.fromQuery[_root_.scala.Option[List[String]]]("id", None), params.fromQuery[Long]("limit", Some(25)), params.fromQuery[Long]("offset", Some(0)), params.fromQuery[String]("sort", Some("-created_at")), params.fromQuery[_root_.scala.Option[List[String]]]("expand", None)) { (id, limit, offset, sort, expand) =>
        controllers_Memberships_get2_invoker.call(Memberships_0.get(id, limit, offset, sort, expand))
      }
  }
}