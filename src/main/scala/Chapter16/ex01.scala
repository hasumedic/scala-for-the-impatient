package Chapter16

import scala.xml.Node

object ex01 extends App {

  val xml: Node = <fred/>(0)

  //xml is a Node, because '<fred/>' is a NodeSeq, and we're accessing the first element of that sequence
}
