package Chapter14

object Ex10 {

  def compose(f: Double => Option[Double], g: Double => Option[Double]): Double => Option[Double] = g(_).flatMap(f)

}
