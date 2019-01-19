name := "cleanArchSample"

version := "1.0"

lazy val scalacSettings = Seq(
  scalaVersion := "2.12.8",
  scalacOptions := Seq(
    "-feature",
    "-language:implicitConversions",
    "-language:postfixOps",
    "-unchecked",
    "-deprecation",
    "-encoding", "utf8",
    "-Ywarn-adapted-args"
  )
)

lazy val playDependencies = Seq(
  guice,
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
)

lazy val `cleanarchsample` = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(libraryDependencies ++= playDependencies)
