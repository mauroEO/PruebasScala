ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.3.3",
  "org.postgresql" % "postgresql" % "42.3.4",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.3",
  "com.github.tminglei" %% "slick-pg" % "0.20.3",
  "com.github.tminglei" %% "slick-pg_play-json" % "0.20.3",
  "org.typelevel" %% "cats-effect" % "3.3.14",
  "com.typesafe.akka" %% "akka-actor" % "2.6.20",
  "io.jvm.uuid" %% "scala-uuid" % "0.3.1"
)

lazy val root = (project in file("."))
  .settings(
    name := "slick"
  )
