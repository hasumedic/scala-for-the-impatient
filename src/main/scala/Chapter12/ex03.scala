package Chapter12

object Ex03 {
  def factorial(n: Long): Long = {
    val initialValue = if (n < 1) 1 else n
    (initialValue to 1 by -1) reduceLeft (_ * _)
  }
}
