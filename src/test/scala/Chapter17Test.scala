import Chapter17._
import org.scalatest.{FlatSpec, Matchers}

class Chapter17Test extends FlatSpec with Matchers {

  "Exercise 1" should "define an immutable data structure that swaps its elements which can be of different types" in {

    val pairs = List(
      new ex01.Pair(10, 9),
      new ex01.Pair('a', 'b'),
      new ex01.Pair("One", "Two"),
      new ex01.Pair("One", 2),
      new ex01.Pair('t', 4.4)
    )

    pairs.foreach { pair =>
      pair.swap.first shouldBe pair.second
      pair.swap.second shouldBe pair.first
    }
  }

  "Exercise 2" should "define a mutable data structure that swaps its elements of the same type" in {

    val pairs = List(
      new ex02.Pair(10, 9),
      new ex02.Pair('a', 'b'),
      new ex02.Pair("One", "Two")
    )

    pairs.foreach { pair =>
      val initialFirst = pair.first
      val initialSecond = pair.second
      pair.swap()
      pair.first shouldBe initialSecond
      pair.second shouldBe initialFirst
    }
  }

  "Exercise 3" should "define a pair data structure and a function swap which returns a new pair swapping its elements" in {

    val pairs = List(
      new ex03.Pair(10, 9),
      new ex03.Pair('a', 'b'),
      new ex03.Pair("One", "Two"),
      new ex03.Pair("One", 2),
      new ex03.Pair('t', 4.4)
    )

    pairs.foreach { pair =>
      val swappedPair = ex03.swap(pair)
      swappedPair.first shouldBe pair.second
      swappedPair.second shouldBe pair.first
    }
  }

  "Exercise 6" should "determine the middle of an Iterable[T]" in {
    ex06.middle(List(1, 2, 3, 4, 5)) shouldBe 3
    ex06.middle("String") shouldBe 'r'
  }

  "Exercise 10" should "provide a type constraint which allows to call swap only for type parameters that are the same" in {
    "val pair = new ex10.Pair(10, 20); pair.swap" should compile
    "val pair = new ex10.Pair('a', \"String\"); pair.swap" shouldNot compile
  }
  it should "swap its elements" in {
    val intPair = new ex10.Pair(10, 9)
    intPair.swap
    intPair.first shouldBe 9
    intPair.second shouldBe 10

    val charPair = new ex10.Pair('a', 'b')
    charPair.swap
    charPair.first shouldBe 'b'
    charPair.second shouldBe 'a'
  }
}
