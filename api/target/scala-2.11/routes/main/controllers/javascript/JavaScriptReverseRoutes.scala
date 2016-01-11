
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mikeroth/GitRepos/group/api/conf/routes
// @DATE:Mon Jan 11 15:11:43 EST 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.io.flow.group.v0.Bindables._

// @LINE:5
package controllers.javascript {
  import ReverseRouteContext.empty

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