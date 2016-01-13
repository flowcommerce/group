
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mikeroth/GitRepos/group/api/conf/routes
// @DATE:Tue Jan 12 06:57:55 EST 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.io.flow.group.v0.Bindables._

// @LINE:5
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:8
  class ReverseMemberships(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def get: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Memberships.get",
      """
        function(id,limit,offset,sort,expand) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "memberships" + _qS([(""" + implicitly[QueryStringBindable[_root_.scala.Option[List[String]]]].javascriptUnbind + """)("id", id), (limit == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("limit", limit)), (offset == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("offset", offset)), (sort == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("sort", sort)), (""" + implicitly[QueryStringBindable[_root_.scala.Option[List[String]]]].javascriptUnbind + """)("expand", expand)])})
        }
      """
    )
  
  }

  // @LINE:5
  class ReverseGroups(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def get: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Groups.get",
      """
        function(id,limit,offset,sort) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "groups" + _qS([(""" + implicitly[QueryStringBindable[_root_.scala.Option[List[String]]]].javascriptUnbind + """)("id", id), (limit == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("limit", limit)), (offset == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("offset", offset)), (sort == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("sort", sort))])})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseHealthchecks(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def getInternalAndHealthcheck: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Healthchecks.getInternalAndHealthcheck",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "_internal_/healthcheck"})
        }
      """
    )
  
  }


}