import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "scritter"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    "com.typesafe" %% "slick" % "1.0.0-RC1",
    "org.slf4j" % "slf4j-nop" % "1.6.4",
    "org.specs2" %% "specs2" % "1.13" % "test",
    "org.mockito" % "mockito-all" % "1.9.0"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
