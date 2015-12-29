package Chapter09

import java.io.File

class Counter {
  private def subdirs(dir: File): Iterator[File] = {
    val children = dir.listFiles.filter(_.isDirectory)
    children.toIterator ++ children.toIterator.flatMap(subdirs)
  }

  def count(dir: File): Int = {
    val classFileRegEx = """.*class$""".r
    val files = for {
      d <- subdirs(dir)
      fileName <- d.listFiles.map(_.getName)
      matchingFile <- classFileRegEx.findFirstIn(fileName)
    } yield matchingFile

    files.size
  }
}

object Counting extends App {
  val counter = new Counter
  val tmpDir = new File(System.getProperty("java.io.tmpdir"))
  val counted = counter.count(tmpDir)
  println(counted)
}
