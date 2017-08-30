import Chapter12._
import org.scalatest.{Matchers, FlatSpec}

class Chapter12Test extends FlatSpec with Matchers {

  "Exercise 1" should "provide a function that satisfies the given example" in {
    Ex01.values(x => x * x, -5, 5) shouldBe List(
      (-5, 25),
      (-4, 16),
      (-3, 9),
      (-2, 4),
      (-1, 1),
      (0, 0),
      (1, 1),
      (2, 4),
      (3, 9),
      (4, 16),
      (5, 25)
    )
  }
  it should "correctly apply to other integer operations" in {
    Ex01.values(x => x - 3, 4, 8) shouldBe List(
      (4, 1),
      (5, 2),
      (6, 3),
      (7, 4),
      (8, 5)
    )
  }

  "Exercise 2" should "obtain the largest element in an array by reducing left" in {
    val arrayOfInt = 1 to 100 toArray
    val arrayOfDouble = arrayOfInt.map(_.toDouble)

    Ex02.maxElementInArray(arrayOfInt) shouldBe 100
    Ex02.maxElementInArray(arrayOfDouble) shouldBe 100.0
  }

  "Exercise 3" should "implement factorial using 'to' and 'reduceLeft'" in {
    Ex03.factorial(0) shouldBe 1
    Ex03.factorial(7) shouldBe 5040
    Ex03.factorial(17) shouldBe 355687428096000L
  }

  "Exercise 4" should "implement factorial using 'foldLeft" in {
    Ex04.factorial(0) shouldBe 1
    Ex04.factorial(7) shouldBe 5040
    Ex04.factorial(17) shouldBe 355687428096000L
  }

  "Exercise 5" should "yield the largest value of a function within a given sequence of inputs" in {
    Ex05.largest(x => 10 * x - x * x, 1 to 10) shouldBe 25
    Ex05.largest(x => x * x - x, 10 to 1 by -1) shouldBe 90
  }

  "Exercise 6" should "yield the input at which the output is largest" in {
    Ex06.largest(x => 10 * x - x * x, 1 to 10) shouldBe 5
    Ex06.largest(x => x * x - x, 10 to 1 by -1) shouldBe 10
  }

  "Exercise 7" should "facilitate calculations with sequence of pairs" in {
    val pairs = (1 to 10) zip (11 to 20)
    pairs.map(pair => Ex07.adjustToPair(_ + _)(pair)) shouldBe List(
      12,
      14,
      16,
      18,
      20,
      22,
      24,
      26,
      28,
      30
    )

    pairs.map(pair => Ex07.adjustToPair(_ * _)(pair)) shouldBe List(
      11,
      24,
      39,
      56,
      75,
      96,
      119,
      144,
      171,
      200
    )
  }

  "Exercise 8" should "check whether the elements in an array of strings have the lengths given in an array of integers" in {
    val arrayOfStrings = Array("Hello", "World")
    val wrongArrayOfIntegers = Array(4, 4)
    val rightArrayOfIntegers = Array(5, 5)

    Ex08.corresponds(arrayOfStrings, wrongArrayOfIntegers)(Ex08.StringsToCount) shouldBe false

    Ex08.corresponds(arrayOfStrings, rightArrayOfIntegers)(Ex08.StringsToCount) shouldBe true
  }

  "Exercise 10" should "implement unless control abstraction" in {
    var counter = 10

    Ex10.unless(counter == 0) {
      counter -= 1
    }

    counter shouldBe 10

    Ex10.unless(counter == 10) {
      counter -= 1
    }

    counter shouldBe 9
  }
}
