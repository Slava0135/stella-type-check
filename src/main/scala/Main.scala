package io.github.slava0135.stella

import java.nio.file.{Files, Paths}

object Main {
  def main(args: Array[String]): Unit = {
    if (args.length < 1) {
      Console.err.println("no arguments provided (expected 1)")
      sys.exit(1)
    }
    if (args.length > 1) {
      Console.err.println("too many arguments (expected 1)")
      sys.exit(1)
    }
    val path = Paths.get(args.apply(0))
    if (!path.getFileName.toString.endsWith(".st")) {
      Console.err.println(s"\"${path.getFileName}\": wrong file extension (expected \"*.st\")")
      sys.exit(1)
    }
    val text = Files.readString(path)
    val unsupported = TypeCheck.unsupportedExtensions(text)
    if (unsupported.nonEmpty) {
      Console.err.println(s"unsupported extensions: ${unsupported.addString(new StringBuilder(), ",")}")
      sys.exit(1)
    }
    TypeCheck.go(text) match {
      case Ok() => sys.exit(1)
      case Bad(message) =>
        Console.err.println(message)
        sys.exit(1)
    }
  }
}
