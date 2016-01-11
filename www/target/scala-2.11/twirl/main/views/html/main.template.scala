
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Option[String],Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(
  title: String,
  headTitle: Option[String] = None
)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.17*/("""

"""),format.raw/*6.1*/("""<!DOCTYPE html>
<html>
<head>
    <title>"""),_display_(/*9.13*/headTitle/*9.22*/.getOrElse(title)),format.raw/*9.39*/("""</title>
    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*10.55*/routes/*10.61*/.Assets.at("images/favicon.ico")),format.raw/*10.93*/("""">
    <link rel='stylesheet' href='"""),_display_(/*11.35*/routes/*11.41*/.WebJarAssets.at(WebJarAssets.locate("bootstrap.min.css"))),format.raw/*11.99*/("""'>
    <script type='text/javascript' src='"""),_display_(/*12.42*/routes/*12.48*/.WebJarAssets.at(WebJarAssets.locate("jquery.min.js"))),format.raw/*12.102*/("""'></script>
    <style>
    body """),format.raw/*14.10*/("""{"""),format.raw/*14.11*/("""
        """),format.raw/*15.9*/("""margin-top: 50px;
    """),format.raw/*16.5*/("""}"""),format.raw/*16.6*/("""
    """),format.raw/*17.5*/("""</style>
</head>
<body>
    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container-fluid">
                <a id="titleLink" class="brand" href="/">"""),_display_(/*23.59*/title),format.raw/*23.64*/("""</a>
            </div>
        </div>
    </div>
    <div class="container">
        """),_display_(/*28.10*/content),format.raw/*28.17*/("""
    """),format.raw/*29.5*/("""</div>
</body>
</html>
"""))
      }
    }
  }

  def render(title:String,headTitle:Option[String],content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title,headTitle)(content)

  def f:((String,Option[String]) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title,headTitle) => (content) => apply(title,headTitle)(content)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Mon Jan 11 11:38:16 EST 2016
                  SOURCE: /Users/mikeroth/GitRepos/group/www/app/views/main.scala.html
                  HASH: 29e2481a356a59485b913f9005e8228b7a9c6b67
                  MATRIX: 545->1|710->71|738->73|806->115|823->124|860->141|950->204|965->210|1018->242|1082->279|1097->285|1176->343|1247->387|1262->393|1338->447|1399->480|1428->481|1464->490|1513->512|1541->513|1573->518|1801->719|1827->724|1941->811|1969->818|2001->823
                  LINES: 20->1|28->4|30->6|33->9|33->9|33->9|34->10|34->10|34->10|35->11|35->11|35->11|36->12|36->12|36->12|38->14|38->14|39->15|40->16|40->16|41->17|47->23|47->23|52->28|52->28|53->29
                  -- GENERATED --
              */
          