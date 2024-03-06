package io.github.slava0135.stella

import stellaParser._

import scala.collection.mutable
import scala.jdk.CollectionConverters.IteratorHasAsScala

class CaseTree(val t: Type) {
  val cases: mutable.Map[PatternContext, Option[CaseTree]] = mutable.Map.empty
  def uncovered(): Seq[String] = {
    val patterns = cases.keys
    if (patterns.exists(p => p.isInstanceOf[PatternVarContext])) {
      return Seq.empty
    }
    t match {
      case Sum(_, _) =>
        var res = List.empty[String]
        if (!patterns.exists(p => p.isInstanceOf[PatternInlContext])) {
          res = res :+ "inl(_)"
        }
        if (!patterns.exists(p => p.isInstanceOf[PatternInrContext])) {
          res = res :+ "inr(_)"
        }
        res
      case Variant(tags) =>
        val matchedLabels = patterns
          .filter(it => it.isInstanceOf[PatternVariantContext])
          .map(it => it.asInstanceOf[PatternVariantContext].label.getText).toSeq
        tags.filterNot(it => matchedLabels.contains(it.name)).map(it => s"<| ${it.name} = _ |>")
    }
  }
}

object Exhaustiveness {
  def check(t: Type, ctx: MatchContext): Either[Error, Unit] = {
    val root = new CaseTree(t)
    ctx.cases.iterator().asScala.map(it => it.pattern()).foreach { it =>
      var tree = root
      var loop = true
      var nextT = t
      var pat = it
      while (loop) {
        (pat, nextT) match {
          case (ctx: PatternVarContext, _) =>
            tree.cases.put(ctx, None)
            loop = false
          case (ctx: PatternInlContext, Sum(nextT, _)) =>
            tree = tree.cases.getOrElseUpdate(ctx, Some(new CaseTree(nextT))).get
            pat = ctx.pattern()
          case (ctx: PatternInrContext, Sum(_, nextT)) =>
            tree = tree.cases.getOrElseUpdate(ctx, Some(new CaseTree(nextT))).get
            pat = ctx.pattern()
          case (ctx: PatternVariantContext, prevT: Variant) =>
            val tag = ctx.label.getText
            nextT = prevT.tag(tag).get
            tree = tree.cases.getOrElseUpdate(ctx, Some(new CaseTree(nextT))).get
            pat = ctx.pattern()
        }
      }
    }
    val unmatched = root.uncovered()
    if (unmatched.nonEmpty) {
      Left(ERROR_NONEXHAUSTIVE_MATCH_PATTERNS(unmatched, ctx))
    } else {
      Right()
    }
  }
}
