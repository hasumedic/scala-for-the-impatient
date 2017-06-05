package Chapter11

import scala.annotation.tailrec
import scala.math.abs

case class Fraction(private val num: Int, private val denom: Int) {

  def numerator: Int = if (denom == 0) 1 else num * sign(denom) / gcd(num, denom)

  def denominator: Int = if (denom == 0) 0 else denom * sign(denom) / gcd(num, denom)

  override def toString: String = s"$numerator/$denominator"

  def +(other: Fraction): Fraction = {
    val commonDenominator = denominator * other.denominator

    Fraction(
      (numerator * commonDenominator) / denominator + (other.numerator * commonDenominator) / other.denominator,
      commonDenominator
    )
  }

  def -(other: Fraction): Fraction = {
    this.+(Fraction(-other.num, other.denom))
  }

  def *(other: Fraction): Fraction = {
    Fraction(
      num * other.num,
      denom * other.denom
    )
  }

  def /(other: Fraction): Fraction = {
    val maximumCommonDenominator = denom * other.denom
    Fraction(
      (maximumCommonDenominator / denom) * num,
      (maximumCommonDenominator / other.denom) * other.num
    )
  }

  private def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

  @tailrec
  private def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)
}
