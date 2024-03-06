package io.github.slava0135.stella

import stellaParser._

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters.IteratorHasAsScala

class CaseTree(val t: Type) {
  val cases: mutable.Map[PatternContext, Option[CaseTree]] = mutable.Map.empty
  def uncovered(): Seq[String] = {
    val patterns = cases.keys
    if (patterns.exists(p => p.isInstanceOf[PatternVarContext])) {
      return Seq.empty
    }
    var res = ListBuffer.empty[String]
    t match {
      case Sum(_, _) =>
        if (!patterns.exists(p => p.isInstanceOf[PatternInlContext])) {
          res += "inl(_)"
        }
        if (!patterns.exists(p => p.isInstanceOf[PatternInrContext])) {
          res += "inr(_)"
        }
        res addAll cases.flatMap { it =>
          it match {
            case (_: PatternInlContext, Some(tree)) => tree.uncovered().map(it => s"inl($it)")
            case (_: PatternInrContext, Some(tree)) => tree.uncovered().map(it => s"inr($it)")
            case _ => Seq.empty
          }
        }
      case Variant(tags) =>
        val matchedLabels = patterns
          .filter(it => it.isInstanceOf[PatternVariantContext])
          .map(it => it.asInstanceOf[PatternVariantContext].label.getText)
          .toSeq
        res addAll tags.filterNot(it => matchedLabels.contains(it.name)).map(it => s"<| ${it.name} = _ |>")
        res addAll cases.flatMap { it =>
          it match {
            case (ctx: PatternVariantContext, Some(tree)) =>
              tree.uncovered().map(it => s"<| ${ctx.label.getText} = $it |>")
            case _ => Seq.empty
          }
        }
      case UnitT() =>
        if (!patterns.exists(p => p.isInstanceOf[PatternUnitContext])) {
          res += "unit"
        }
      case Bool() =>
        if (!patterns.exists(p => p.isInstanceOf[PatternFalseContext])) {
          res += "false"
        }
        if (!patterns.exists(p => p.isInstanceOf[PatternTrueContext])) {
          res += "true"
        }
    }
    res.toSeq
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
      def stop(ctx: PatternContext): Unit = {
        tree.cases.put(ctx, None)
        loop = false
      }
      while (loop) {
        (pat, nextT) match {
          case (ctx: PatternVarContext, _) =>
            stop(ctx)
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
          case (ctx: PatternUnitContext, _: UnitT) =>
            stop(ctx)
          case (ctx: PatternFalseContext, _: Bool) =>
            stop(ctx)
          case (ctx: PatternTrueContext, _: Bool) =>
            stop(ctx)
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
