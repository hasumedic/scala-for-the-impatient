package Chapter09

import java.io.{PrintWriter, File}
import java.nio.file.Path

class PowerPrinter {
  def print: Path = {
    val file = File.createTempFile("PowerPrinter", "txt")
    val out = new PrintWriter(file)

    for (i <- 0 until 20) {
      out.println(math.pow(2, i) + "\t" + math.pow(2, -i))
    }
    out.close()
    file.toPath
  }

}
