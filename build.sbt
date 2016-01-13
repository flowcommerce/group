import play.PlayImport.PlayKeys._
import scoverage.ScoverageSbtPlugin.ScoverageKeys._

name := "group"

scalaVersion in ThisBuild := "2.11.7"

// required because of issue between scoverage & sbt
parallelExecution in Test in ThisBuild := true

lazy val generated = project
  .in(file("generated"))
  .enablePlugins(PlayScala)
  .settings(
    libraryDependencies ++= Seq(
      ws
    )
  )

lazy val api = project
  .in(file("api"))
  .dependsOn(generated)
  .aggregate(generated)
  .enablePlugins(PlayScala)
  .settings(commonSettings: _*)
  .settings(
    routesImport += "io.flow.group.v0.Bindables._",
    routesGenerator := InjectedRoutesGenerator,
    libraryDependencies ++= Seq(
      ws,
      jdbc,
      "io.flow" %% "lib-play" % "0.0.19",
      "io.flow" %% "lib-postgresql" % "0.0.17",
      "com.typesafe.play" %% "anorm" % "2.5.0",
      "org.postgresql" % "postgresql" % "9.4-1206-jdbc42",
      "org.scalatestplus" %% "play" % "1.4.0-M4" % "test"
    )
  )

lazy val www = project
  .in(file("www"))
  .dependsOn(generated)
  .aggregate(generated)
  .enablePlugins(PlayScala)
  .settings(commonSettings: _*)
  .settings(
    routesImport += "io.flow.group.v0.Bindables._",
    libraryDependencies ++= Seq(
      "org.webjars" %% "webjars-play" % "2.4.0-2",
      "org.webjars" % "bootstrap" % "3.3.6",
      "org.webjars" % "jquery" % "2.1.4"
    )
  )

lazy val commonSettings: Seq[Setting[_]] = Seq(
  name <<= name("group-" + _),
  libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "2.2.6" % "test"
  ),
  scalacOptions += "-feature",
  coverageHighlighting := true
)
