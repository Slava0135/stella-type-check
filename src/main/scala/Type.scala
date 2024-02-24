package io.github.slava0135.stella

sealed trait Type

final case class Nat() extends Type
final case class Bool() extends Type
final case class Fun(param: Type, res: Type) extends Type
