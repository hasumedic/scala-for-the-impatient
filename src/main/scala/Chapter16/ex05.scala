package Chapter16

import scala.xml.{NodeSeq, XML}

object ex05 extends App {

  private lazy val xml: NodeSeq =
    XML.load(getClass.getResource("/Chapter16/ex05.xml"))

  def printImageNames(): Unit =
    for {
      elem <- xml \\ "img" \\ "@src"
    } yield println(elem)

  printImageNames()
}
