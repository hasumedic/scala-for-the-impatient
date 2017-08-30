package Chapter12

object Ex07 {
  def adjustToPair(f: (Int, Int) => Int)(pair: (Int, Int)): Int = f(pair._1, pair._2)
}
