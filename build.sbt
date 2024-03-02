import sbtassembly.AssemblyKeys.{assembly, assemblyJarName}

val v = "0.1.0"
ThisBuild / version := v

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "stella-type-check",
    idePackagePrefix := Some("io.github.slava0135.stella"),
    assembly / assemblyJarName := s"stella-type-check-$v.jar"
  )

javacOptions ++= Seq("-source", "17", "-target", "17")

libraryDependencies += "org.antlr" % "antlr4-runtime" % "4.13.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % "test"
