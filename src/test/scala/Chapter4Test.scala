import Chapter4._

import java.util.Calendar

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.SortedMap

class Chapter4Test extends FlatSpec with Matchers {

  "exercise 1" should "provide a 10% discount on a given map of prices" in {
    val gizmos = Map("phone" -> 99.99, "watch" -> 89.99, "gps" -> 149.49)
    Chapter4.exercise1(gizmos) should be(Map("phone" -> 90.00, "watch" -> 81.00, "gps" -> 135.00))
  }

  "exercise 2" should "count the words for the given text file" in {
    Chapter4.exercise2("Chapter4-2.txt") should be(Map("This" -> 2, "is" -> 2, "just" -> 2, "a" -> 2, "test." -> 2))
  }

  "exercise 3" should "count the words for the given text file" in {
    Chapter4.exercise3("Chapter4-3.txt") should be(Map("This" -> 2, "is" -> 2, "just" -> 1, "a" -> 2, "test." -> 2))
  }

  "exercise 4" should "count the words for the given text file and print them in order" in {
    Chapter4.exercise3("Chapter4-4.txt") should be(SortedMap("A" -> 1, "a" -> 2, "is" -> 2, "just" -> 1, "test" -> 1, "test." -> 2, "This" -> 1))
  }

  "exercise 6" should "create a LinkedHashMap for the days of the week in order" in {
    var loopedMap: List[Int] = Nil
    for ((k, v) <- Chapter4.exercise6()) {
      loopedMap = loopedMap :+ v
    }
    loopedMap should contain theSameElementsInOrderAs List(Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY, Calendar.SATURDAY, Calendar.SUNDAY)
  }

  "exercise 8" should "throw an exception given an empty array" in {
    intercept[IllegalArgumentException] {
      Chapter4.exercise8(Array())
    }
  }
  "exercise 8" should "calculate min and max for a given array base cases" in {
    Chapter4.exercise8(Array(1)) should be((1, 1))
    Chapter4.exercise8(Array(1, 1, 1)) should be((1, 1))
    Chapter4.exercise8(Array(1, 2)) should be((1, 2))
    Chapter4.exercise8(Array(2, 1)) should be((1, 2))
  }
  "exercise 8" should "calculate min and max for a given array with repeated values" in {
    Chapter4.exercise8(Array(1, 1, 2, 2, 3, 3)) should be(1, 3)
  }
  "exercise 8" should "calculate min and max for a given array with negatives" in {
    Chapter4.exercise8(Array(1, -1, 2, -2, 3, -3)) should be(-3, 3)
  }

  "exercise 9" should "throw an exception given an empty array" in {
    intercept[IllegalArgumentException] {
      Chapter4.exercise9(Array(), 10)
    }
  }
  "exercise 9" should "return the correct counts for base cases" in {
    Chapter4.exercise9(Array(1), 5) should be((1, 0, 0))
    Chapter4.exercise9(Array(1), 1) should be((0, 1, 0))
    Chapter4.exercise9(Array(1), 0) should be((0, 0, 1))
  }
  "exercise 9" should "return the correct counts given larger arrays" in {
    Chapter4.exercise9(Array(1, 2, 3, 4, 5, 6, 7, 8, 9), 5) should be((4, 1, 4))
  }
  "exercise 9" should "return the correct counts given negative numbers" in {
    Chapter4.exercise9(Array(-1, 2, 0, -3, 4, -5, 0, -6, 7, 8, -9), 0) should be((5, 2, 4))
  }
}
