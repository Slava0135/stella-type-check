package io.github.slava0135.stella

import org.scalatest.funspec.AnyFunSpec

import java.nio.file.{FileSystems, Files, Path}
import scala.jdk.CollectionConverters.IteratorHasAsScala

class TestTypeCheck extends AnyFunSpec {
  describe("bad") {
    val testDir = FileSystems.getDefault.getPath("src", "test", "resources", "stella-tests", "bad")
    Files.list(testDir).iterator().asScala.foreach { errors =>
      val errorTag = errors.getFileName.toString
      describe(errorTag) {
        Files.list(errors).iterator().asScala.foreach { test =>
          val testName = test.getFileName.toString
          it(testName) {

          }
        }
      }
    }
  }
}
