import Chapter06._
import org.scalatest.{Matchers, FlatSpec}

class Chapter6Test extends FlatSpec with Matchers {
  "exercise 1" should "implement an object Conversions that converts inches to cm" in {
    Conversions.inchesToCentimeters(0) should be(0)
    Conversions.inchesToCentimeters(10) should be(25.4)
    Conversions.inchesToCentimeters(14.3) should be(36.32)
  }
  "exercise 1" should "implement an object Conversions that converts gallons to liters" in {
    Conversions.gallonsToLiters(0) should be(0)
    Conversions.gallonsToLiters(4) should be(18.18)
    Conversions.gallonsToLiters(3.24) should be(14.73)
  }
  "exercise 1" should "implement an object Conversions that converts miles to kilometers" in {
    Conversions.milesToKilometers(0) should be(0)
    Conversions.milesToKilometers(14) should be(22.53)
    Conversions.milesToKilometers(21.11) should be(33.97)
  }

  "exercise 2" should "implement a super class UnitConversion with object InchesToCentimeters that implement it" in {
    InchesToCentimeters.convert(0) should be(0)
    InchesToCentimeters.convert(10) should be(25.4)
    InchesToCentimeters.convert(14.3) should be(36.32)
  }
  "exercise 2" should "implement a super class UnitConversion with object GallonsToLiters that implement it" in {
    GallonsToLiters.convert(0) should be(0)
    GallonsToLiters.convert(4) should be(18.18)
    GallonsToLiters.convert(3.24) should be(14.73)
  }
  "exercise 2" should "implement a super class UnitConversion with object MilesToKilometers that implement it" in {
    MilesToKilometers.convert(0) should be(0)
    MilesToKilometers.convert(14) should be(22.53)
    MilesToKilometers.convert(21.11) should be(33.97)
  }

  "exercise 4" should "define a Point class which can be constructed as Point(3, 4)" in {
    Point(3, 4).x should be (3)
    Point(3, 4).y should be (4)
  }
}
