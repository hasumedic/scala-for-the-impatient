package Chapter14

object Ex02 {

  def swap(pair: (Int, Int)): (Int, Int) = pair match {
    case (x, y) => (y, x)
  }

}
