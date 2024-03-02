package io.github.slava0135.stella

import stellaParser.{PatternContext, PatternFalseContext, PatternInlContext, PatternInrContext, PatternIntContext, PatternSuccContext, PatternTrueContext, PatternVarContext, PatternVariantContext}

import scala.collection.immutable

sealed trait Type {
  def unmatchedPatterns(patterns: Seq[PatternContext]): Seq[String] = Seq("???")
}

final case class Unknown() extends Type {
  override def toString: String = "???"
  override def equals(obj: Any): Boolean = false
}

final case class Nat() extends Type {
  override def toString: String = "Nat"

  override def unmatchedPatterns(patterns: Seq[PatternContext]): Seq[String] = {
    if (patterns.exists(p => p.isInstanceOf[PatternVarContext])) {
      return Seq.empty
    }
    var res = List.empty[String]
    val nums = patterns
      .filter(it => it.isInstanceOf[PatternIntContext])
      .map(it => it.asInstanceOf[PatternIntContext].n.getText.toInt)
    if (!nums.contains(0)) {
      res = res :+ "0"
    }
    if (!patterns.exists(p => p.isInstanceOf[PatternSuccContext])) {
      res = res :+ "succ(_)"
    }
    res
  }
}

final case class Bool() extends Type {
  override def toString: String = "Bool"

  override def unmatchedPatterns(patterns: Seq[PatternContext]): Seq[String] = {
    if (patterns.exists(p => p.isInstanceOf[PatternVarContext])) {
      return Seq.empty
    }
    var res = List.empty[String]
    if (!patterns.exists(p => p.isInstanceOf[PatternFalseContext])) {
      res = res :+ "false"
    }
    if (!patterns.exists(p => p.isInstanceOf[PatternTrueContext])) {
      res = res :+ "true"
    }
    res
  }
}

final case class Fun(param: Type, res: Type) extends Type {
  override def toString: String = s"($param -> $res)"
}

final case class UnitT() extends Type {
  override def toString: String = "Unit"
  override def unmatchedPatterns(patterns: Seq[PatternContext]): Seq[String] = {
    if (patterns.exists(p => p.isInstanceOf[PatternVarContext])) {
      return Seq.empty
    }
    if (!patterns.exists(p => p.isInstanceOf[PatternInrContext])) {
      Seq("unit")
    }
    Seq()
  }
}

final case class Tuple(types: immutable.Seq[Type]) extends Type {
  override def equals(obj: Any): Boolean = {
    obj match {
      case other: Tuple =>
        types.length == other.types.length && types.indices.forall(i => types.apply(i) == other.types.apply(i))
      case _ =>
        false
    }
  }
  override def toString: String = s"{${types.addString(new StringBuilder(), ", ")}}"
}

final case class RecordField(name: String, t: Type) {
  override def toString: String = s"$name : $t"
}
final case class Record(fields: immutable.Seq[RecordField]) extends Type {
  def field(name: String): Option[Type] = {
    fields.filter(f => f.name == name).map(it => it.t).headOption
  }
  override def equals(obj: Any): Boolean = {
    obj match {
      case other: Record =>
        fields.length == other.fields.length && fields.indices.forall(i => fields.apply(i) == other.fields.apply(i))
      case _ =>
        false
    }
  }
  override def toString: String = s"{${fields.addString(new StringBuilder(), ", ")}}"
}

final case class Sum(left: Type, right: Type) extends Type {
  override def toString: String = s"$left + $right"

  override def unmatchedPatterns(patterns: Seq[PatternContext]): Seq[String] = {
    if (patterns.exists(p => p.isInstanceOf[PatternVarContext])) {
      return Seq.empty
    }
    var res = List.empty[String]
    if (!patterns.exists(p => p.isInstanceOf[PatternInlContext])) {
      res = res :+ "inl(_)"
    }
    if (!patterns.exists(p => p.isInstanceOf[PatternInrContext])) {
      res = res :+ "inr(_)"
    }
    res
  }
}

final case class ListT(t: Type) extends Type {
  override def toString: String = s"[$t]"
}

final case class VariantTag(name: String, t: Type) {
  override def toString: String = s"$name : $t"
}
final case class Variant(tags: immutable.Seq[VariantTag]) extends Type {
  def tag(name: String): Option[Type] = {
    tags.filter(f => f.name == name).map(it => it.t).headOption
  }
  override def equals(obj: Any): Boolean = {
    obj match {
      case other: Variant =>
        tags.length == other.tags.length && tags.indices.forall(i => tags.apply(i) == other.tags.apply(i))
      case _ =>
        false
    }
  }
  override def toString: String = s"<| ${tags.addString(new StringBuilder(), ", ")} |>"

  override def unmatchedPatterns(patterns: Seq[PatternContext]): Seq[String] = {
    if (patterns.exists(p => p.isInstanceOf[PatternVarContext])) {
      return Seq.empty
    }
    val matchedLabels = patterns
      .filter(it => it.isInstanceOf[PatternVariantContext])
      .map(it => it.asInstanceOf[PatternVariantContext].label.getText)
    tags.filterNot(it => matchedLabels.contains(it.name)).map(it => s"<| ${it.name} = _ |>")
  }
}
