name := "funproxy"

version := "0.0.1"

lazy val scalaVersion = "2.11.7"
lazy val jettyVersion = "9.3.7.v20160115"
lazy val scalatraVersion = "2.4.0"
lazy val undetowVersion = "1.3.16.Final"

ivyScala := ivyScala.value map {
  _.copy(overrideScalaVersion = true)
}

libraryDependencies += "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"
libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.14"
libraryDependencies += "junit" % "junit" % "4.10" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.5" % "test"
libraryDependencies += "org.scalatra" %% "scalatra" % scalatraVersion
libraryDependencies += "org.scalatra" %% "scalatra-scalate" % scalatraVersion
//libraryDependencies += "org.scalatra" %% "scalatra-specs2" % scalatraVersion % "test"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3" % "runtime"
libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.11.2"
libraryDependencies += "org.eclipse.jetty" % "jetty-webapp" % "8.1.8.v20121106" % "compile;container"
libraryDependencies += "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "compile;provided;test"
//scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")






