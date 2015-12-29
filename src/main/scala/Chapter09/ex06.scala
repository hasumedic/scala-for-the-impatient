package Chapter09

import scala.io.Source

class QuotePrinter(source: Source) {

  private def stripQuotes(occurrences: Array[String]): Array[String] = {
    occurrences.map(_.replaceAll( """["\\]""", ""))
  }

  def print(): Array[String] = {
    val doubleQuotes = """["\"\\"]+([a-zA-Z ]+)["\"\\"]+""".r
    val occurrences = doubleQuotes.findAllIn(source.getLines().mkString).toArray
    stripQuotes(occurrences)
  }
}
