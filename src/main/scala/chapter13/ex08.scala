package chapter13

object Ex08 {

  def toDimensions(input: Array[Int], columns: Int): Array[Array[Int]] = input.grouped(columns).toArray

}
