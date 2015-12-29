package Chapter09

import scala.io.Source

class LongWordDetector(source: Source) {
  def detect(): Array[String] = {
    """[a-zA-Z]{12,}""".r.findAllIn(source.getLines().mkString).toArray
  }
}
