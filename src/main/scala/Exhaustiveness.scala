package io.github.slava0135.stella

import stellaParser._

import scala.jdk.CollectionConverters.IteratorHasAsScala

object Exhaustiveness {
  def check(t: Type, ctx: MatchContext): Either[Error, Unit] = {
    val unmatched = t.unmatchedPatterns(ctx.cases.iterator().asScala.map(it => it.pattern()).toSeq)
    if (unmatched.nonEmpty) {
      Left(ERROR_NONEXHAUSTIVE_MATCH_PATTERNS(unmatched, ctx))
    } else {
      Right()
    }
  }
}
