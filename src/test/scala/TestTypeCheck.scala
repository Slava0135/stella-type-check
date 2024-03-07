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
          val unsupported = TypeCheck.unsupportedExtensions(text)
          if (unsupported.isEmpty) {
            it(testName, Tag(errorTag), Tag(testName)) {
              TypeCheck.go(text) match {
                case Ok() =>
                  fail(s"($testName:1) no errors found")
                case Bad(msg) =>
                  if (!msg.contains(errorTag)) {
                    val errorPattern = "// *(ERROR_[_A-Z]+)".r
                    val altErrors = text.lines()
                      .iterator().asScala
                      .flatMap(it => errorPattern.findAllMatchIn(it))
                      .flatMap(it => Option(it.group(1)))
                      .toSeq
                    altErrors.find(e => msg.contains(e)) match {
                      case Some(err) => info.apply(s"($testName:1) /!\\ alternative error tag: $err\n$msg")
                      case None => fail(s"($testName:1) wrong error type\n$msg")
                    }
                  }
              }
            }
          } else {
            ignore(s"$testName ~ ${unsupported.addString(new StringBuilder(), ",")}") {
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
      val unsupported = TypeCheck.unsupportedExtensions(text)
      if (unsupported.isEmpty) {
        it(testName, Tag(testName)) {
          TypeCheck.go(text) match {
            case Ok() =>
            case Bad(msg) =>
              fail(s"($testName:1) invalid error:\n$msg")
          }
        }
      } else {
        ignore(s"$testName ~ ${unsupported.addString(new StringBuilder(), ",")}") {
        }
      }
    }
  }
}
