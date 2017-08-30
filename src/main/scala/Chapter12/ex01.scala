package Chapter12

object Ex01 {

  def values(f: (Int) => Int, min: Int, max: Int): Seq[(Int, Int)] = {
    (min to max).map { value =>
      (value, f(value))
    }
  }

}
