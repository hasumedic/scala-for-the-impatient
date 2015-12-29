package Chapter09

import scala.io.Source

class LineReverter(source: Source) {
  def revert(): String = {
    source.getLines().toArray.reverse.mkString("\n")
  }
}
