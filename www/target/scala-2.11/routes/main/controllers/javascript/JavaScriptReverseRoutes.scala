
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mikeroth/GitRepos/group/www/conf/routes
// @DATE:Mon Jan 11 11:38:15 EST 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.io.flow.group.v0.Bindables._

// @LINE:1
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:7
  class ReverseWebJarAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WebJarAssets.at",
      """
        function(file) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "webjars/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
        }
      """
    )
  
  }

  // @LINE:1
  class ReverseApplicationController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:1
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApplicationController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:2
  class ReverseHealthchecksController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HealthchecksController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "_internal_/healthcheck"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
        }
      """
    )
  
  }


}