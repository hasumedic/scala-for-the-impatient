package chapter13

object Ex02 {

  def indices(input: String): Map[Char, List[Int]] = {
    input.zipWithIndex.groupBy(_._1).map {
      case (k, v) => (k, v.map(_._2).toList)
    }
  }
}
