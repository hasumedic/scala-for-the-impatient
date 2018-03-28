package Chapter16

import scala.xml.{NodeSeq, XML}

object ex06 extends App {

  private lazy val xml: NodeSeq =
    XML.load(getClass.getResource("/Chapter16/ex06.xml"))

  def printHyperlinks(): Unit =
    for {
      elem <- xml \\ "a"
    } yield
      elem.attribute("href").foreach { href =>
        println(s"${elem.text} -> $href")
      }

  printHyperlinks()
}
