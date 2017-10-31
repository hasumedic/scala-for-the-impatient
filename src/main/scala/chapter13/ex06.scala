package Chapter13

object Ex06 {

  def reverseFold(input: List[Int]): List[Int] = (List[Int]() :\ input.reverse)(_ +: _)

}
