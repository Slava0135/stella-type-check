package io.github.slava0135.stella

import scala.collection.immutable

sealed trait Type

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
  override def toString: String = s"($param -> $res)"
}
final case class UnitT() extends Type {
  override def toString: String = "Unit"
}
final case class Tuple(types: immutable.ArraySeq[Type]) extends Type {
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
final case class Record(fields: immutable.ArraySeq[RecordField]) extends Type {
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