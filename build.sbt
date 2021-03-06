name := "funproxy"
version := "0.0.1"
scalaVersion := "2.11.7"

lazy val akkaVersion = "2.3.13"
lazy val jettyVersion = "9.1.0.v20131115"
lazy val scalatraVersion = "2.4.0"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % akkaVersion
libraryDependencies += "org.scalatra" %% "scalatra" % scalatraVersion
libraryDependencies += "org.scalatra" %% "scalatra-scalate" % scalatraVersion
libraryDependencies += "org.scalatra" %% "scalatra-json" % scalatraVersion
libraryDependencies += "org.json4s"   %% "json4s-jackson" % "3.3.0"
libraryDependencies += "org.eclipse.jetty" % "jetty-webapp" % jettyVersion % "compile;runtime"
libraryDependencies += "org.eclipse.jetty" % "jetty-plus" % jettyVersion % "compile;runtime"
libraryDependencies += "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3" % "runtime"
libraryDependencies += "com.github.philcali" %% "cronish" % "0.1.3"
libraryDependencies += "com.typesafe.play" %% "play-ws" % "2.4.3"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"
libraryDependencies += "org.scalatra" %% "scalatra-specs2" % scalatraVersion % "test"
libraryDependencies += "org.scalatra" %% "scalatra-scalatest" % scalatraVersion % "test"
libraryDependencies += "com.netaporter" %% "scala-uri" % "0.4.12" % "test"

dependencyOverrides += "org.slf4j" % "slf4j-api" % "1.7.13"