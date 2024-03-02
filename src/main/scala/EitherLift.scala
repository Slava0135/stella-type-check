package io.github.slava0135.stella

object EitherLift {
  def liftEither[A, B](s: Seq[Either[A, B]]): Either[A, Seq[B]] =
    s.foldRight(Right(Nil): Either[A, List[B]]) {
      (e, acc) => for (xs <- acc; x <- e) yield x :: xs
    }
}
