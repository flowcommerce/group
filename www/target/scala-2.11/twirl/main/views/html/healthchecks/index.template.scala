
package views.html.healthchecks

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.19*/("""

"""),_display_(/*3.2*/main("group healthcheck")/*3.27*/ {_display_(Seq[Any](format.raw/*3.29*/("""
  """),_display_(/*4.4*/message),format.raw/*4.11*/("""
""")))}),format.raw/*5.2*/("""
"""))
      }
    }
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Mon Jan 11 11:38:16 EST 2016
                  SOURCE: /Users/mikeroth/GitRepos/group/www/app/views/healthchecks/index.scala.html
                  HASH: 9b3af3aa4a2643ce04e473aa02f6e021b5a4a115
                  MATRIX: 540->1|652->18|680->21|713->46|752->48|781->52|808->59|839->61
                  LINES: 20->1|25->1|27->3|27->3|27->3|28->4|28->4|29->5
                  -- GENERATED --
              */
          