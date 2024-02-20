package io.github.slava0135.stella

import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}

object Main {
  def main(args: Array[String]): Unit = {
    val text =
      """
        |language core;
        |
        |// addition of natural numbers
        |fn Nat::add(n : Nat) -> fn(Nat) -> Nat {
        |  return fn(m : Nat) {
        |    return Nat::rec(n, m, fn(i : Nat) {
        |      return fn(r : Nat) {
        |        return succ( r ); // r := r + 1
        |      };
        |    });
        |  };
        |}
        |
        |// square, computed as a sum of odd numbers
        |fn square(n : Nat) -> Nat {
        |  return Nat::rec(n, 0, fn(i : Nat) {
        |      return fn(r : Nat) {
        |        // r := r + (2*i + 1)
        |        return Nat::add(i)( Nat::add(i)( succ( r )));
        |      };
        |  });
        |}
        |
        |fn main(n : Nat) -> Nat {
        |  return square(n);
        |}
        |""".stripMargin
    val lexer = new stellaLexer(CharStreams.fromString(text))
    val parser = new stellaParser(new CommonTokenStream(lexer))
    val root = parser.program()
    println(root.accept(new TestVisitor))
  }
}

class TestVisitor extends stellaParserBaseVisitor[Nothing] {

}
