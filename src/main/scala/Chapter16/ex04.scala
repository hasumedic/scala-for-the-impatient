package Chapter16

import scala.xml.{Node, NodeSeq, XML}

object ex04 extends App {

  private lazy val xml: NodeSeq =
    XML.load(getClass.getResource("/Chapter16/ex04.xml"))

  def printImagesWithoutAlt(): Unit =
    for {
      elem <- xml \\ "img"
      if doesNotContainAltAttribute(elem)
    } yield println(elem)

  private def doesNotContainAltAttribute(node: Node): Boolean =
    node.attribute("alt").isEmpty

  printImagesWithoutAlt()
}
