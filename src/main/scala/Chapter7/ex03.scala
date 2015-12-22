package Chapter7.random

object RandomNumberGenerator {
  private var previous: Int = 0

  private val a = 1664525
  private val b = 1013904223
  private val n = 32

  def setSeed(seed: Int): Unit = {
    this.previous = seed
  }

  def nextInt: Int = {
    previous = (previous * a + b) % scala.math.pow(2, n).toInt
    previous
  }

  def nextDouble: Double = nextInt.toDouble
}
