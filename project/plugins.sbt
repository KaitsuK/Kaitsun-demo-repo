// The Play plugin
//addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.4.2")
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.4.2")

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
// resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// web plugins

addSbtPlugin("com.typesafe.sbt" % "sbt-coffeescript" % "1.0.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-less" % "1.0.6")

addSbtPlugin("com.typesafe.sbt" % "sbt-jshint" % "1.0.3")

addSbtPlugin("com.typesafe.sbt" % "sbt-rjs" % "1.0.7")

addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.1.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-mocha" % "1.1.0")
