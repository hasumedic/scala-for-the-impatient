import Chapter13._
import org.scalatest.{FlatSpec, Matchers}

class Chapter13Test extends FlatSpec with Matchers {

  //Exercise 1 - Not interested in mutable structures

  "Exercise 2" should "produce a map of sets containing the indices of the letter of the given word" in {
    Ex02.indices("Mississippi") shouldBe Map(
      'M' -> List(0),
      'i' -> List(1, 4, 7, 10),
      's' -> List(2, 3, 5, 6),
      'p' -> List(8, 9)
    )
  }

  "Exercise 3" should "remove all zeroes from a linked list of integers" in {
    val input = List(1, 2, 4, 1, 5, 7, 9, 0, 0, 8, 7, 6, 6, 8, 9, 0, 0, 8, 7, 5, 5, 7, 8, 0)
    val expected = List(1, 2, 4, 1, 5, 7, 9, 8, 7, 6, 6, 8, 9, 8, 7, 5, 5, 7, 8)

    Ex03.removeZeroes(input) shouldBe expected
  }

  "Exercise 4" should "correctly return associated indexes of strings within a map given a map and a List of strings" in {

    Ex04.findIndexesInMap(List.empty[String], Map.empty[String, Int]) shouldBe Array.empty[Int]
    Ex04.findIndexesInMap(List("Some", "Names"), Map.empty[String, Int]) shouldBe Array.empty[Int]
    Ex04.findIndexesInMap(List.empty[String], Map("Some" -> 3, "Values" -> 4)) shouldBe Array.empty[Int]

    Ex04.findIndexesInMap(List("Found", "NotFound"), Map("Some" -> 5, "Values" -> 4, "Found" -> 1)) shouldBe Array(1)
    Ex04.findIndexesInMap(List("Found", "Multiple"), Map("Some" -> 5, "Multiple" -> 4, "Found" -> 1)) shouldBe Array(1, 4)
  }

  "Exercise 5" should "implement reduceLeftString which behaves like mkString" in {
    val input = List("Some", "Words", "To", "Concatenate")

    Ex05.reduceLeftString(input) shouldBe "Some Words To Concatenate"

    Ex05.reduceLeftString(input, "++") shouldBe "Some++Words++To++Concatenate"
  }

  "Exercise 6" should "reverse a list using folds" in {
    val input = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val expected = List(9, 8, 7, 6, 5, 4, 3, 2, 1)

    Ex06.reverseFold(input) shouldBe expected
  }

  "Exercise 7" should "use 'tupled' to allow mapping over functions with two parameters" in {
    val prices = List(5.0, 20.0, 9.95)
    val quantities = List(10, 2, 1)

    val multiply = (x: Double, y: Int) => x * y

    (prices zip quantities) map multiply.tupled shouldBe List(50.0, 40.0, 9.95)
  }

  "Exercise 8" should "group an array into 2 dimensions by the given column number" in {
    val initialArray = Array(1, 2, 3, 4, 5, 6)

    Ex08.toDimensions(initialArray, columns = 3) shouldBe Array(Array(1, 2, 3), Array(4, 5, 6))

    Ex08.toDimensions(initialArray, columns = 1) shouldBe Array(Array(1), Array(2), Array(3), Array(4), Array(5), Array(6))
  }

  //Exercise 9 - Not interested in mutable structures

  //Exercise 10 - Not interested in mutable structures
}
