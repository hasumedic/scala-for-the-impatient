package Chapter12

object Ex02 {
  def maxElementInArray[T: Ordering](array: Array[T]): T = {
    array.reduceLeft((x, y) => {
      if (implicitly[Ordering[T]].compare(x, y) < 0) y
      else x
    })
  }
}
