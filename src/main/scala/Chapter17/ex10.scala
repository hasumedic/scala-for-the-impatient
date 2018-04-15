package Chapter17

object ex10 {

  class Pair[S, T](var first: S, var second: T) {

    def swap(implicit ev1: S =:= T, ev2: T =:= S): Unit = {
      val tmp = first
      first = second
      second = tmp
    }

  }

}
