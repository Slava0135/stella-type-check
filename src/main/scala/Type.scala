package io.github.slava0135.stella

import scala.collection.immutable

sealed trait Type {
  def isSubtypeOf(other: Type)(implicit subtypingEnabled: Boolean): Boolean
}

final case class Unknown() extends Type {
  override def toString: String = "???"
  override def equals(obj: Any): Boolean = false
  override def isSubtypeOf(other: Type)(implicit subtypingEnabled: Boolean): Boolean = false
}

final case class Nat() extends Type {
  override def toString: String = "Nat"
  override def isSubtypeOf(other: Type)(implicit subtypingEnabled: Boolean): Boolean = {
    if (!subtypingEnabled) return this == other
    other match {
      case Nat() => true
      case Top() => true
      case _ => false
    }
  }
}

final case class Bool() extends Type {
  override def toString: String = "Bool"
  override def isSubtypeOf(other: Type)(implicit subtypingEnabled: Boolean): Boolean = {
    if (!subtypingEnabled) return this == other
    other match {
      case Bool() => true
      case Top() => true
      case _ => false
    }
  }
}

final case class Fun(param: Type, res: Type) extends Type {
  override def toString: String = s"($param -> $res)"
  override def isSubtypeOf(other: Type)(implicit subtypingEnabled: Boolean): Boolean = {
    if (!subtypingEnabled) return this == other
    other match {
      case Fun(otherParam, otherRes) => res.isSubtypeOf(otherRes) && otherParam.isSubtypeOf(param)
      case Top() => true
      case _ => false
    }
  }
}

final case class UnitT() extends Type {
  override def toString: String = "Unit"
  override def isSubtypeOf(other: Type)(implicit subtypingEnabled: Boolean): Boolean = {
    if (!subtypingEnabled) return this == other
    other match {
      case UnitT() => true
      case Top() => true
      case _ => false
    }
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
  override def isSubtypeOf(other: Type)(implicit subtypingEnabled: Boolean): Boolean = {
    if (!subtypingEnabled) return this == other
    other match {
      case Tuple(otherTypes) => otherTypes.length == types.length && otherTypes.indices.forall { i => types(i).isSubtypeOf(otherTypes(i)) }
      case Top() => true
      case _ => false
    }
  }
  override def toString: String = s"{${types.addString(new StringBuilder(), ", ")}}"
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
  override def isSubtypeOf(other: Type)(implicit subtypingEnabled: Boolean): Boolean = {
    if (!subtypingEnabled) return this == other
    other match {
      case Record(otherFields) => otherFields.forall { otherField =>
        field(otherField.name) match {
          case Some(t) => t.isSubtypeOf(otherField.t)
          case None => false
        }
      }
      case Top() => true
      case _ => false
    }
  }
  override def toString: String = s"{${fields.addString(new StringBuilder(), ", ")}}"
}

final case class Sum(left: Type, right: Type) extends Type {
  override def toString: String = s"$left + $right"
  override def isSubtypeOf(other: Type)(implicit subtypingEnabled: Boolean): Boolean = {
    if (!subtypingEnabled) return this == other
    other match {
      case Sum(otherLeft, otherRight) => left.isSubtypeOf(otherLeft) && right.isSubtypeOf(otherRight)
      case Top() => true
      case _ => false
    }
  }
}

final case class ListT(t: Type) extends Type {
  override def toString: String = s"[$t]"
  override def isSubtypeOf(other: Type)(implicit subtypingEnabled: Boolean): Boolean = {
    if (!subtypingEnabled) return this == other
    other match {
      case ListT(otherT) => t.isSubtypeOf(otherT)
      case Top() => true
      case _ => false
    }
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
  override def isSubtypeOf(other: Type)(implicit subtypingEnabled: Boolean): Boolean = {
    if (!subtypingEnabled) return this == other
    other match {
      case otherVariant@Variant(_) => tags.forall { tag =>
        otherVariant.tag(tag.name) match {
          case Some(otherT) => tag.t.isSubtypeOf(otherT)
          case None => false
        }
      }
      case Top() => true
      case _ => false
    }
  }
  override def toString: String = s"<| ${tags.addString(new StringBuilder(), ", ")} |>"
}

final case class Ref(t: Type) extends Type {
  override def toString: String = s"&$t"
  override def isSubtypeOf(other: Type)(implicit subtypingEnabled: Boolean): Boolean = {
    if (!subtypingEnabled) return this == other
    other match {
      case Ref(otherT) => t == otherT
      case Top() => true
      case _ => false
    }
  }
}

final case class Bot() extends Type {
  override def toString: String = "Bot"
  override def isSubtypeOf(other: Type)(implicit subtypingEnabled: Boolean): Boolean = {
    if (!subtypingEnabled) return this == other
    other match {
      case Unknown() => false
      case _ => true
    }
  }
}

final case class Top() extends Type {
  override def toString: String = "Top"
  override def isSubtypeOf(other: Type)(implicit subtypingEnabled: Boolean): Boolean = other == Top()
}
