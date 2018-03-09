package Chapter14

object Ex03 {

  def swap(list: List[Int]): List[Int] = list match {
    case x :: y :: ys => y :: x :: ys
    case _ => list
  }

}
