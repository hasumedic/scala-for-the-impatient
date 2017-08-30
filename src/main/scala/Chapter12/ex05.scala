package Chapter12

object Ex05 {
  def largest(f: (Int) => Int, inputs: Seq[Int]): Int = inputs.map(f).max
}
