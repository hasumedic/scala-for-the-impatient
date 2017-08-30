package Chapter12

object Ex04 {
  def factorial(n: Long): Long =
    (n to 1 by -1).foldLeft(1L)((acc, value) => acc * value)
}
