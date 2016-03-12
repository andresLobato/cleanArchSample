name := "cleanArchSample"

version := "1.0"

lazy val scalacSettings = Seq(
  scalaVersion := "2.11.7",
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

lazy val playResolvers = Seq(
  "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
)

lazy val playDependencies = Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test
)

lazy val playSettings = Seq(
  routesGenerator := InjectedRoutesGenerator,
  unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )
)

lazy val `cleanarchsample` = (project in file("."))
  .settings(scalacSettings ++ playSettings: _*)
  .settings(resolvers ++= playResolvers)
  .settings(libraryDependencies ++= playDependencies)
  .enablePlugins(PlayScala)
