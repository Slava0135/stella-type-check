ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "stella-type-check",
    idePackagePrefix := Some("io.github.slava0135.stella")
  )

libraryDependencies += "org.antlr" % "antlr4-runtime" % "4.13.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % "test"
