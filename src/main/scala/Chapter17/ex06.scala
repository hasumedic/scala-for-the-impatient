package Chapter17

object ex06 {

  def middle[T](iterable: Iterable[T]): T = {
    val middlePoint: Int = math.floor(iterable.size / 2).toInt - {
      if (iterable.size % 2 == 0) 1 else 0
    }

    iterable.drop(middlePoint).head
  }

}
