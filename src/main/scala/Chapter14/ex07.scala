package Chapter14

object Ex07 {

  sealed abstract class BinaryTree
  case class Leaf(value: Int) extends BinaryTree
  case class Node(trees: BinaryTree*) extends BinaryTree

  def leafSum(tree: BinaryTree): Int = tree match {
    case Leaf(value) => value
    case Node(trees @ _*) => trees.foldLeft(0)(_ + leafSum(_))
  }

}
