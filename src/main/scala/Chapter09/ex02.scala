package Chapter09

import java.io.{File, PrintWriter}
import java.nio.file.Path

import scala.io.Source

class TabRemover(source: Source) {
  def remove(): Path = {
    val file = File.createTempFile("TabRemover", "txt")
    val out = new PrintWriter(file)
    val tabPattern = "\t".r

    for (line <- source.getLines()) {
      out.println(tabPattern.replaceAllIn(line, "    "))
    }
    out.close()
    file.toPath
  }
}
