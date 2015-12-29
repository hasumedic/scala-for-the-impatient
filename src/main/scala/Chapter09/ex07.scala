package Chapter09

import scala.io.Source

class NonFloatingPointPrinter(source: Source) {
  lazy val floatingPointRegEx = """[^\d+\.\d+ ]+""".r
  def print: Array[String] = {
    val tokens = source.mkString.split("\\s+")
    tokens.filter(floatingPointRegEx.findFirstIn(_).isDefined)
  }
}
