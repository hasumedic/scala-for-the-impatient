package Chapter09

import scala.io.Source

class FloatingPointCalculator(source: Source) {

  def extractValues: Array[Double] = source.getLines().map(_ toDouble).toArray

  def calculate(): CalculatorResults = {
    val values = extractValues
    CalculatorResults(values.sum, values.sum / values.length, values.max, values.min)
  }
}

case class CalculatorResults(total: Double, average: Double, maximum: Double, minimum: Double)
