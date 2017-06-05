package Chapter11

import scala.math.floor

case class Money(dollars: Int, cents: Int) {
  require(dollars >= 0 && cents >= 0 && cents < 100)

  def +(other: Money): Money = {
    val allCents: Int = cents + other.cents
    Money(
      dollars + other.dollars + floor(allCents / 100).toInt,
      allCents % 100
    )
  }

  def -(other: Money): Money = {
    Money(
      dollars - other.dollars - (if (cents - other.cents > 0) 0 else 1),
      cents % other.cents
    )
  }
}
