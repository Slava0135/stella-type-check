package io.github.slava0135.stella

sealed trait Result

final case class Ok() extends Result
final case class Bad(message: String) extends Result
