package Chapter16

import scala.collection.immutable.Seq
import scala.xml.{Node, NodeSeq}

object ex08 {

  // This function naively expects the descriptionList parameter to be a description list
  def buildMapFromDescriptionList(descriptionList: NodeSeq): Map[String, String] = {
    descriptionList match {
      case <dl>{children@_*}</dl> => buildTupleSequence(children).map { tuple =>
        tuple._1.text -> tuple._2.text
      }.toMap
      case _ => Map.empty[String, String]
    }
  }

  private def buildTupleSequence(children: Seq[Node]): Seq[(Node, Node)] = {
    extractDts(children) zip extractDds(children)
  }

  private def extractDts(children: Seq[Node]): NodeSeq = {
    extractFromChildren(children, "dt")
  }

  private def extractDds(children: Seq[Node]): NodeSeq = {
    extractFromChildren(children, "dd")
  }

  private def extractFromChildren(children: Seq[Node], s: String) = for {
    element <- children \\ s
  } yield element
}
