import PlayingCardSuits.PlayingCardSuit

import scala.math.BigDecimal.RoundingMode

object Chapter6

//Exercise 1
object Conversions {

  private val inchesToCentimetersRatio = 0.39370
  private val gallonsToLitersRatio = 4.54609
  private val milesToKilometersRatio = 0.62137

  private def roundUp(number: Double): Double = {
    BigDecimal(number).setScale(2, RoundingMode.HALF_UP).toDouble
  }

  def inchesToCentimeters(inches: Double): Double = roundUp(inches / inchesToCentimetersRatio)

  def gallonsToLiters(gallons: Double): Double = roundUp(gallons * gallonsToLitersRatio)

  def milesToKilometers(miles: Double): Double = roundUp(miles / milesToKilometersRatio)
}


//Exercise 2
abstract class UnitConversion {
  def convert(unit: Double): Double

  def roundUp(number: Double): Double = {
    BigDecimal(number).setScale(2, RoundingMode.HALF_UP).toDouble
  }
}

object InchesToCentimeters extends UnitConversion {
  private val ratio = 0.39370

  override def convert(unit: Double): Double = roundUp(unit / ratio)
}

object GallonsToLiters extends UnitConversion {
  private val ratio = 4.54609

  override def convert(unit: Double): Double = roundUp(unit * ratio)
}

object MilesToKilometers extends UnitConversion {
  private val ratio = 0.62137

  override def convert(unit: Double): Double = roundUp(unit / ratio)
}

//Exercise 3
object Origin extends java.awt.Point

//This looks like a bad idea. Creating a singleton extending a mutable object...

//Exercise 4
class Point(val x: Int, val y: Int)

object Point {
  def apply(x: Int, y: Int): Point = new Point(x, y)
}

//Exercise 5
object ReverseArgs extends App {
  print(args.reverse.mkString(" "))
}

//Exercise 6
object PlayingCardSuits extends Enumeration {
  type PlayingCardSuit = Value

  val Club = Value("\u2663")
  val Diamond = Value("\u2666")
  val Heart = Value("\u2666")
  val Spade = Value("\u2660")
}

//Exercise 7
object exercise7 {
  def isRed(suit: PlayingCardSuit): Boolean = suit == PlayingCardSuits.Heart || suit == PlayingCardSuits.Diamond
}

//Exercise 8
object RGBColorCube extends Enumeration {
  type RBGColor = Value

  val Black = Value(0x000000)
  val Red = Value(0xFF0000)
  val Green = Value(0x00FF00)
  val Blue = Value(0x0000FF)
  val Cyan = Value(0x00FFFF)
  val Magenta = Value(0xFF00FF)
  val Yellow = Value(0xFFFF00)
  val White = Value(0xFFFFFF)
}