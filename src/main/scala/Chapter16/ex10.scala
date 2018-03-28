package Chapter16

import scala.io.Source
import scala.xml.dtd.{DocType, PublicID}
import scala.xml.{Node, XML}
import scala.xml.parsing.ConstructingParser

object ex10 extends App {

  private lazy val parser = ConstructingParser.fromSource(
    Source.fromURL(getClass.getResource("/Chapter16/ex10.xml")),
    preserveWS = true)
  private lazy val xml: Node = parser.document().docElem

  val modifiedXml = ex09.addTodosToImages(xml)

  XML.save("target/exercise10Save.xml", modifiedXml.head, doctype = DocType("html", PublicID("-//W3C//DTD XHTML 1.0 Transitional//EN", "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"), Nil))


}
