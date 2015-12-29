package Chapter09

import scala.io.Source

class ImageLocator {

  lazy val imgTagRegEx = """<\s*?img\s+[^>]?src="(.*?)"\s+[^>]*>""".r

  def locate(source: Source): Array[String] = {
    val html = source.getLines().mkString
    var result: List[String] = List()
    for (imgTagRegEx(image) <- imgTagRegEx findAllIn html) {
      result = result ++ List(image)
    }
    result.toArray
  }
}
