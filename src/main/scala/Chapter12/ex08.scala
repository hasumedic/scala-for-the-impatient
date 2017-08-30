package Chapter12

object Ex08 {

  def corresponds[A, B](seqA: Seq[A], seqB: Seq[B])(p: (A, B) => Boolean): Boolean =
    (seqA zip seqB).forall(pair => p(pair._1, pair._2))

  def StringsToCount: (String, Int) => Boolean =
    (string, count) => string.length == count
}
