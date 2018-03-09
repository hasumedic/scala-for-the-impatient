package Chapter14

object Ex05 {

  def leafSum(list: List[Any]): Int = list.map {
    case x: List[Any] => leafSum(x)
    case y: Int => y
    case _ => 0
  }.sum

}
