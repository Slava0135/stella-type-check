package io.github.slava0135.stella

import org.scalatest.Tag
import org.scalatest.funspec.AnyFunSpec

import java.nio.file.{FileSystems, Files, Paths}
import scala.jdk.CollectionConverters.IteratorHasAsScala

class TestTypeCheck extends AnyFunSpec {
  private val basePath =  FileSystems.getDefault.getPath("src", "test", "resources", "stella-tests").toString
  describe("bad") {
    val testDir = Paths.get(basePath, "bad")
    Files.list(testDir).iterator().asScala.foreach { errors =>
      val errorTag = errors.getFileName.toString
      describe(errorTag) {
        Files.list(errors).iterator().asScala.foreach { test =>
          val testName = test.getFileName.toString
          val text = Files.readString(test)
          if (TypeCheck.isSupported(text)) {
            it(testName, Tag(errorTag), Tag(testName)) {
              TypeCheck.go(text) match {
                case Ok() =>
                  fail(s"($testName:1) no errors found")
                case Bad(msg) =>
                  if (!msg.contains(errorTag)) {
                    fail(s"($testName:1) wrong error type\n$msg")
                  }
              }
            }
          } else {
            ignore(s"($testName:1) : unsupported extension") {
            }
          }
        }
      }
    }
  }
  describe("ok") {
    val testDir = Paths.get(basePath, "ok")
    Files.list(testDir).iterator().asScala.foreach { test =>
      val testName = test.getFileName.toString
      val text = Files.readString(test)
      if (TypeCheck.isSupported(text)) {
        it(testName, Tag(testName)) {
          TypeCheck.go(text) match {
            case Ok() =>
            case Bad(msg) =>
              fail(s"($testName:1) invalid error:\n$msg")
          }
        }
      } else {
        ignore(s"($testName:1) : unsupported extension") {
        }
      }
    }
  }
}
