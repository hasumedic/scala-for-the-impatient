package Chapter12

object Ex06 {
  def largest(f: (Int) => Int, inputs: Seq[Int]): Int = inputs.reduceLeft {
    (previous, next) =>
      if (f(previous) > f(next)) previous else next
  }
}
