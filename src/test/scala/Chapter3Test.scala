import org.scalatest.{Matchers, FlatSpec}

import scala.collection.mutable.ArrayBuffer

class Chapter3Test extends FlatSpec with Matchers {

  "exercise 1" should "create an array of size n with elements between 0 and n-1" in {
    val array1 = Chapter3.Chapter3.exercise1(3)
    array1.length should be(3)
    array1.forall(element => element >= 0 && element < 3)

    val array2 = Chapter3.Chapter3.exercise1(10)
    array2.length should be(10)
    array1.forall(element => element >= 0 && element < 10)
  }

  "exercise 2" should "swap nothing on empty input" in {
    Chapter3.Chapter3.exercise2(Array()) should be(Array())
  }
  "exercise 2" should "swap nothing on arrays with a single element" in {
    Chapter3.Chapter3.exercise2(Array(1)) should be(Array(1))
  }
  "exercise 2" should "swap the elements on an array with 2 elements" in {
    Chapter3.Chapter3.exercise2(Array(1, 2)) should be(Array(2, 1))
  }
  "exercise 2" should "swap the elements on an array with multiple elements" in {
    Chapter3.Chapter3.exercise2(Array(1, 2, 3, 4, 5)) should be(Array(2, 1, 4, 3, 5))
  }

  // Exercise 3 is the same as 2 but is looking for a slightly different implementation
  "exercise 3" should "swap nothing on empty input" in {
    Chapter3.Chapter3.exercise3(Array()) should be(Array())
  }
  "exercise 3" should "swap nothing on arrays with a single element" in {
    Chapter3.Chapter3.exercise3(Array(1)) should be(Array(1))
  }
  "exercise 3" should "swap the elements on an array with 2 elements" in {
    Chapter3.Chapter3.exercise3(Array(1, 2)) should be(Array(2, 1))
  }
  "exercise 3" should "swap the elements on an array with multiple elements" in {
    Chapter3.Chapter3.exercise3(Array(1, 2, 3, 4, 5)) should be(Array(2, 1, 4, 3, 5))
  }

  "exercise 4" should "reorder nothing given an empty array" in {
    Chapter3.Chapter3.exercise4(Array()) should be(Array())
  }
  "exercise 4" should "reorder nothing given an array with a single element" in {
    Chapter3.Chapter3.exercise4(Array(-10)) should be(Array(-10))
  }
  "exercise 4" should "reorder given an array with a couple of elements" in {
    Chapter3.Chapter3.exercise4(Array(-10, 10)) should be(Array(10, -10))
  }
  "exercise 4" should "reorder given an array with multiple elements" in {
    Chapter3.Chapter3.exercise4(Array(-10, 10, 5, -5)) should be(Array(10, 5, -10, -5))
  }
  "exercise 4" should "reorder given an array with multiple elements including zeros" in {
    Chapter3.Chapter3.exercise4(Array(-10, 0, 10, 5, -5)) should be(Array(10, 5, -10, 0, -5))
  }

  "exercise 5" should "return 0 as average for an empty double array" in {
    Chapter3.Chapter3.exercise5(Array()) should be(0)
  }
  "exercise 5" should "return the element contained in a single element array as its average" in {
    Chapter3.Chapter3.exercise5(Array(5)) should be(5)
  }
  "exercise 5" should "return the average of an array with two elements" in {
    Chapter3.Chapter3.exercise5(Array(0, 5)) should be(2.5)
  }
  "exercise 5" should "return the average of an array containing negative elements" in {
    Chapter3.Chapter3.exercise5(Array(-5, 5)) should be(0)
  }
  "exercise 5" should "return the average of multiple elements in disorder and containing negative elements" in {
    Chapter3.Chapter3.exercise5(Array(8, 2, -4, 0, 4, -1)) should be(1.5)
  }

  "exercise 6 Array" should "should resolve base cases" in {
    Chapter3.Chapter3.exercise6Array(Array()) should be(Array())
    Chapter3.Chapter3.exercise6Array(Array(1)) should be(Array(1))
    Chapter3.Chapter3.exercise6Array(Array(-1)) should be(Array(-1))
  }
  "exercise 6 Array" should "reverse order a short ordered array" in {
    Chapter3.Chapter3.exercise6Array(Array(1, 2, 3, 4)) should be(Array(4, 3, 2, 1))
  }
  "exercise 6 Array" should "reverse order a short unordered array" in {
    Chapter3.Chapter3.exercise6Array(Array(3, 2, 4, 1)) should be(Array(4, 3, 2, 1))
  }
  "exercise 6 Array" should "reverse order a long unordered array with negatives" in {
    Chapter3.Chapter3.exercise6Array(Array(-1, 4, 3, -10, 2, 0)) should be(Array(4, 3, 2, 0, -1, -10))
  }
  "exercise 6 ArrayBuffer" should "should resolve base cases" in {
    Chapter3.Chapter3.exercise6ArrayBuffer(ArrayBuffer()) should be(ArrayBuffer())
    Chapter3.Chapter3.exercise6ArrayBuffer(ArrayBuffer(1)) should be(ArrayBuffer(1))
    Chapter3.Chapter3.exercise6ArrayBuffer(ArrayBuffer(-1)) should be(ArrayBuffer(-1))
  }
  "exercise 6 ArrayBuffer" should "reverse order a short ordered array" in {
    Chapter3.Chapter3.exercise6ArrayBuffer(ArrayBuffer(1, 2, 3, 4)) should be(ArrayBuffer(4, 3, 2, 1))
  }
  "exercise 6 ArrayBuffer" should "reverse order a short unordered array" in {
    Chapter3.Chapter3.exercise6ArrayBuffer(ArrayBuffer(3, 2, 4, 1)) should be(ArrayBuffer(4, 3, 2, 1))
  }
  "exercise 6 ArrayBuffer" should "reverse order a long unordered array with negatives" in {
    Chapter3.Chapter3.exercise6ArrayBuffer(ArrayBuffer(-1, 4, 3, -10, 2, 0)) should be(ArrayBuffer(4, 3, 2, 0, -1, -10))
  }

  "exercise 7" should "remove duplicates from any given array" in {
    Chapter3.Chapter3.exercise7(Array()) should be(Array())
    Chapter3.Chapter3.exercise7(Array(1, 1)) should be(Array(1))
    Chapter3.Chapter3.exercise7(Array(1, 1, 3, 4, 4)) should be(Array(1, 3, 4))
    Chapter3.Chapter3.exercise7(Array('a', 'b', 'b', 'c')) should be(Array('a', 'b', 'c'))
    Chapter3.Chapter3.exercise7(Array(true, true, false)) should be(Array(true, false))
  }

  "exercise 8" should "remove all negative numbers but first occurrence" in {
    Chapter3.Chapter3.exercise8(ArrayBuffer(1, 5, 6, -2, 4, 5, -2, -4, -3)) should be(ArrayBuffer(1, 5, 6, -2, 4, 5))
  }
}
