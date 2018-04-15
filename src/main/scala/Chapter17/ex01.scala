package Chapter17

object ex01 {

  class Pair[T, S](val first: T, val second: S) {
    def swap: Pair[S, T] = new Pair(second, first)
  }

}
