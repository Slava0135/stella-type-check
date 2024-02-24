package io.github.slava0135.stella

sealed trait Type

final case class Unknown() extends Type {
  override def toString: String = "???"
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
