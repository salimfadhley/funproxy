name := "funproxy"

version := "0.0.1"

scalaVersion := "2.11.7"

lazy val scalatraVersion = "2.3.1"
libraryDependencies += "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"
libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.14"
libraryDependencies += "junit" % "junit" % "4.10" % "test"
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.5" % "test"
libraryDependencies += "org.scalatra" %% "scalatra" % scalatraVersion
libraryDependencies += "org.scalatra" %% "scalatra-scalate" % scalatraVersion
libraryDependencies += "org.scalatra" %% "scalatra-specs2" % scalatraVersion % "test"
libraryDependencies += "org.eclipse.jetty" % "jetty-webapp" % "9.2.10.v20150310" % "runtime"
//libraryDependencies +=  "ch.qos.logback"    %  "logback-classic"   % "1.1.3"            % "runtime"
//libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.11.2"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")






