package Chapter16

import scala.xml.NodeSeq

object ex07 {

  def buildDescriptionList(descriptionListAsMap: Map[String, String]): NodeSeq = {
    val descriptionList = <dl></dl>

    val content = descriptionListAsMap.foldLeft(NodeSeq.Empty)((acc, keyValuePair) => acc ++ <dt>{keyValuePair._1}</dt> ++ <dd>{keyValuePair._2}</dd>)

    descriptionList.copy(child = content)
  }

}
