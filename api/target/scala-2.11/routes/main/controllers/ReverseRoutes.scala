
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mikeroth/GitRepos/group/api/conf/routes
// @DATE:Tue Jan 12 06:57:55 EST 2016

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.io.flow.group.v0.Bindables._

// @LINE:5
package controllers {

  // @LINE:8
  class ReverseMemberships(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def get(id:_root_.scala.Option[List[String]], limit:Long = 25, offset:Long = 0, sort:String = "-created_at", expand:_root_.scala.Option[List[String]]): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "memberships" + queryString(List(Some(implicitly[QueryStringBindable[_root_.scala.Option[List[String]]]].unbind("id", id)), if(limit == 25) None else Some(implicitly[QueryStringBindable[Long]].unbind("limit", limit)), if(offset == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("offset", offset)), if(sort == "-created_at") None else Some(implicitly[QueryStringBindable[String]].unbind("sort", sort)), Some(implicitly[QueryStringBindable[_root_.scala.Option[List[String]]]].unbind("expand", expand)))))
    }
  
  }

  // @LINE:5
  class ReverseGroups(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def get(id:_root_.scala.Option[List[String]], limit:Long = 25, offset:Long = 0, sort:String = "lower(name),-created_at"): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "groups" + queryString(List(Some(implicitly[QueryStringBindable[_root_.scala.Option[List[String]]]].unbind("id", id)), if(limit == 25) None else Some(implicitly[QueryStringBindable[Long]].unbind("limit", limit)), if(offset == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("offset", offset)), if(sort == "lower(name),-created_at") None else Some(implicitly[QueryStringBindable[String]].unbind("sort", sort)))))
    }
  
  }

  // @LINE:7
  class ReverseHealthchecks(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def getInternalAndHealthcheck(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "_internal_/healthcheck")
    }
  
  }


}