package Chapter17

object ex03 {

  class Pair[T, S](val first: T, val second: S)

  def swap[T, S](pair: Pair[T, S]): Pair[S, T] = new Pair(pair.second, pair.first)

}
