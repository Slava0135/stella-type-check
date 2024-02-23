package io.github.slava0135.stella

import stellaParser.{StellatypeContext, TypeBoolContext, TypeFunContext, TypeNatContext}

sealed trait Type

object TypeFactory {
  def evalFunType(f: TypeFunContext): Type = {
    Fun(evalType(f.paramTypes.get(0)), evalType(f.returnType))
  }

  def evalType(t: StellatypeContext): Type = {
    t match {
      case _: TypeNatContext => new Nat
      case _: TypeBoolContext => new Bool
      case f: TypeFunContext => evalFunType(f)
    }
  }
}

final case class Nat() extends Type
final case class Bool() extends Type
final case class Fun(param: Type, res: Type) extends Type
