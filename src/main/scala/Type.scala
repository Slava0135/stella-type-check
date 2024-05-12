package io.github.slava0135.stella

sealed trait Type {
  def substitute(from: FreshTypeVar, to: Type): Type = if (this == from) { to } else this
  def contains(t: FreshTypeVar): Boolean = this == t
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
  override def contains(t: FreshTypeVar): Boolean = param.contains(t) || res.contains(t)
}

final case class UnitT() extends Type {
  override def toString: String = "Unit"
}

final case class Pair(fst: Type, snd: Type) extends Type {
  override def toString: String = s"{$fst, $snd}"
  override def substitute(from: FreshTypeVar, to: Type): Type = {
    Pair(fst.substitute(from, to), snd.substitute(from, to))
  }
  override def contains(t: FreshTypeVar): Boolean = fst.contains(t) || snd.contains(t)
}

final case class Sum(left: Type, right: Type) extends Type {
  override def toString: String = s"$left + $right"
  override def substitute(from: FreshTypeVar, to: Type): Type = {
    Sum(left.substitute(from, to), right.substitute(from, to))
  }
  override def contains(t: FreshTypeVar): Boolean = left.contains(t) || right.contains(t)
}

final case class ListT(t: Type) extends Type {
  override def toString: String = s"[$t]"
}
