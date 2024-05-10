package io.github.slava0135.stella

import scala.collection.immutable

sealed trait Type {
  def substitute(from: FreshTypeVar, to: Type): Type = if (this == from) { to } else this
}

final case class FreshTypeVar() extends Type {
  private val id: Int = FreshTypeVar.nextId()
  override def toString: String = s"?T$id"
  override def equals(obj: Any): Boolean = {
    obj match {
      case v: FreshTypeVar => v.id == id
      case _ => false
    }
  }
  override def hashCode(): Int = id
}

private object FreshTypeVar {
  private var id = 1
  private def nextId(): Int = {
    val temp = id
    id += 1
    temp
  }
}

final case class Nat() extends Type {
  override def toString: String = "Nat"
}

final case class Bool() extends Type {
  override def toString: String = "Bool"
}

final case class Fun(param: Type, res: Type) extends Type {
  override def toString: String = s"($param -> $res)"
  override def substitute(from: FreshTypeVar, to: Type): Type = {
    Fun(param.substitute(from, to), res.substitute(from, to))
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
}

final case class Sum(left: Type, right: Type) extends Type {
  override def toString: String = s"$left + $right"
}

final case class ListT(t: Type) extends Type {
  override def toString: String = s"[$t]"
}
