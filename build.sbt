name := """Kissoja"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
resolvers += "Typesafe" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  jdbc,
  evolutions,
  specs2 % Test,
  "com.typesafe.play" %% "anorm" % "2.4.0",
//  "org.scalaz.stream" %% "scalaz-stream" % "0.7a"
//  "org.specs2" %% "specs2-core" % "3.3.1" % "test"
//  "postgresql" % "postgresql" % "9.3-1102-jdbc41",
//  "postgresql" % "postgresql" % "8.4-702.jdbc4",
//  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
//  "postgresql" % "postgresql" % "9.3-1102-jdbc41",
  "org.postgresql" % "postgresql" % "9.4-1201-jdbc41",
//  "postgresql" % "postgresql" % "9.4-1201.jdbc4",
//  "org.apache.commons" % "commons-dbcp2" % "2.0.1",
//  "org.specs2" %% "specs2-core" % "3.6" % "test",
//  "org.specs2" %% "specs2-core" % "3.3.1" % "test",
//  "org.specs2" %% "specs2-scalacheck" % "3.6" % "test",
//  "org.scalaz.stream" %% "scalaz-stream_2.11" % "0.7a",
  cache,
  ws
)


//libraryDependencies ++= "org.scalaz.stream" % "scalaz-stream_2.10" % "0.5a"

// excludeAll(ExclusionRule(organization = "org.specs2"))

// resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

// "com.typesafe.play" %% "play" % playVersion excludeAll(ExclusionRule(organization = "org.specs2"))

//resolvers ++= Seq(
//  "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases",
//  "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/"
//)


// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
