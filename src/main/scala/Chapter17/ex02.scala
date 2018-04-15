package Chapter17

object ex02 {

  class Pair[T](private val a: T, private val b: T) {

    private var currentFirst = a
    private var currentSecond = b

    def first: T = currentFirst
    def second: T = currentSecond

    def swap(): Unit = {
      val first = currentFirst
      currentFirst = currentSecond
      currentSecond = first
    }
  }

}
