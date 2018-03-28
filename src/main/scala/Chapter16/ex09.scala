package Chapter16

import scala.xml._
import scala.xml.transform.{RewriteRule, RuleTransformer}

object ex09 {

  private lazy val transformerRule = new RewriteRule {
    override def transform(n: Node): Seq[Node] = n match {
      case img @ <img/> if img.attribute("alt").isEmpty =>
        img.asInstanceOf[Elem] % Attribute(null, "alt", "TODO", Null)
      case _ => n
    }
  }

  def addTodosToImages(document: NodeSeq): NodeSeq = new RuleTransformer(transformerRule).transform(document)
}
