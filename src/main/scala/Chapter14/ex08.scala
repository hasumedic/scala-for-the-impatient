package Chapter14

object Ex08 {

  sealed trait Operation
  case object Sum extends Operation
  case object Sub extends Operation
  case object Mul extends Operation

  sealed abstract class BinaryTree
  case class Leaf(value: Int) extends BinaryTree
  case class Node(operator: Operation, trees: BinaryTree*) extends BinaryTree

  def eval(tree: BinaryTree): Int = tree match {
    case Leaf(value) => value
    case Node(operator, trees @ _*) => operator match {
      case Sum => trees.foldLeft(0)(_ + eval(_))
      case Sub => trees.foldLeft(0)(_ - eval(_))
      case Mul => trees.foldLeft(1)(_ * eval(_))
    }
  }

}
