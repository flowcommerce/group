
package views.html

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

"""),_display_(/*3.2*/main("Welcome to group")/*3.26*/ {_display_(Seq[Any](format.raw/*3.28*/("""

    """),format.raw/*5.5*/("""<div class="well">
        <h1>"""),_display_(/*6.14*/message),format.raw/*6.21*/("""</h1>
    </div>

""")))}),format.raw/*9.2*/("""
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
                  SOURCE: /Users/mikeroth/GitRepos/group/www/app/views/index.scala.html
                  HASH: 4a3ffd668fbe20fed9ef4957d579409ea7e610c4
                  MATRIX: 527->1|639->18|667->21|699->45|738->47|770->53|828->85|855->92|903->111
                  LINES: 20->1|25->1|27->3|27->3|27->3|29->5|30->6|30->6|33->9
                  -- GENERATED --
              */
          