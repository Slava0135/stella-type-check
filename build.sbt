import sbtassembly.AssemblyKeys.{assembly, assemblyJarName}

ThisBuild / version := "0.1.0"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "stella-type-check",
    idePackagePrefix := Some("io.github.slava0135.stella"),
    assembly / assemblyJarName := s"stella-type-check-${(ThisBuild / version).value}.jar",
    assembly / assemblyOutputPath := target.value / (assembly / assemblyJarName).value
  )

javacOptions ++= Seq("-source", "17", "-target", "17")

libraryDependencies += "org.antlr" % "antlr4-runtime" % "4.13.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % "test"
