package io.github.slava0135.stella

import scala.collection.immutable

sealed trait Type {
  def replace(genericType: GenericType, withType: Type): Type =
    if (this == genericType) withType else this
}

final case class GenericType(name: String) extends Type {
  override def toString: String = name
}

final case class Unknown() extends Type {
  override def toString: String = "???"
  override def equals(obj: Any): Boolean = false
}

final case class Nat() extends Type {
  override def toString: String = "Nat"
}

final case class Bool() extends Type {
  override def toString: String = "Bool"
}

final case class Fun(param: Type, res: Type) extends Type {
  override def toString: String = s"fn ($param) -> $res"
  override def replace(genericType: GenericType, withType: Type): Type = {
    Fun(param.replace(genericType, withType), res.replace(genericType, withType))
  }
}

final case class ForAll(generics: Seq[GenericType], funT: Fun) extends Type {
  override def toString: String = s"forall${generics.map(it => s" $it").mkString}. $funT"
  override def replace(genericType: GenericType, withType: Type): Type = {
    ForAll(generics, funT.replace(genericType, withType).asInstanceOf[Fun])
  }
}

final case class UnitT() extends Type {
  override def toString: String = "Unit"
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
  override def replace(genericType: GenericType, withType: Type): Type = {
    Tuple(types.map(_.replace(genericType, withType)))
  }
}

final case class RecordField(name: String, t: Type) {
  override def toString: String = s"$name : $t"
}
final case class Record(fields: immutable.Seq[RecordField]) extends Type {
  def field(name: String): Option[Type] = {
    fields.filter(f => f.name == name).map(_.t).headOption
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
  override def replace(genericType: GenericType, withType: Type): Type = {
    Record(fields.map(it => RecordField(it.name, it.t.replace(genericType, withType))))
  }
}

final case class Sum(left: Type, right: Type) extends Type {
  override def toString: String = s"$left + $right"
  override def replace(genericType: GenericType, withType: Type): Type = {
    Sum(left.replace(genericType, withType), right.replace(genericType, withType))
  }
}

final case class ListT(t: Type) extends Type {
  override def toString: String = s"[$t]"
  override def replace(genericType: GenericType, withType: Type): Type = {
    ListT(t.replace(genericType, withType))
  }
}

final case class VariantTag(name: String, t: Type) {
  override def toString: String = s"$name : $t"
}
final case class Variant(tags: immutable.Seq[VariantTag]) extends Type {
  def tag(name: String): Option[Type] = {
    tags.filter(f => f.name == name).map(_.t).headOption
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
  override def replace(genericType: GenericType, withType: Type): Type = {
    Variant(tags.map(it => VariantTag(it.name, it.t.replace(genericType, withType))))
  }
}
