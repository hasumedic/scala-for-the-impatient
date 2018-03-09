import Chapter14._
import org.scalacheck.{Arbitrary, Gen}
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers}

import scala.math.sqrt

class Chapter14Test
  extends FlatSpec
    with Matchers
    with GeneratorDrivenPropertyChecks {

  //Exercise 1 - Not interested in JDK internals

  "Exercise 2" should "swap any pair of integers received as input using pattern match" in {
    forAll { (x: Int, y: Int) =>
      Ex02.swap((x, y)) shouldBe(y, x)
    }
  }

  "Exercise 3" should "swap the first two elements of an array when its length is bigger than 2" in {
    val genIntegerListWithAtLeastTwoElements = Gen.nonEmptyListOf(
      Arbitrary.arbitrary[Int]) suchThat (_.size > 1)

    forAll(genIntegerListWithAtLeastTwoElements) { list =>
      val swappedList = Ex03.swap(list)
      swappedList.head shouldBe list.tail.head
      swappedList.tail.head shouldBe list.head
    }
  }
  it should "leave the list as is when its length is 1" in {
    forAll { (x: Int) =>
      Ex03.swap(List(x)) shouldBe List(x)
    }
  }
  it should "ignore the empty list" in {
    Ex03.swap(List.empty[Int]) shouldBe List.empty[Int]
  }

  "Exercise 4" should "include the ability to declare multiple items and price them" in {
    import Ex04._
    val itemToPrice = Multiple(10, Article("Toaster", 29.95))
    val expectedPrice = 299.5

    Ex04.price(itemToPrice) shouldBe expectedPrice
  }
  it should "calculate price for nested items such as Bundles" in {
    import Ex04._
    val itemToPrice = Multiple(10,
      Bundle("fruits",
        2,
        Article("bananas", 2),
        Article("grapefruit", 4),
        Article("oranges", 1)))
    val expectedPrice = 50

    Ex04.price(itemToPrice) shouldBe expectedPrice
  }

  "Exercise 5" should "add the numbers of a tree represented by lists of integers and integers" in {
    Ex05.leafSum(List(List(3, 8), 2, List(5))) shouldBe 18
    Ex05.leafSum(List(1, 2, List(3, List(4)), 5, List(6, 7), 8, 9, 10)) shouldBe 55
  }

  "Exercise 6" should "add the numbers of a binary tree represented by case classes" in {
    import Chapter14.Ex06.{Leaf, Node}

    Ex06.leafSum(Leaf(43)) shouldBe 43
    Ex06.leafSum(Node(Leaf(2), Leaf(0))) shouldBe 2
    Ex06.leafSum(Node(Node(Leaf(4), Leaf(5)), Node(Leaf(6), Leaf(7)))) shouldBe 22
  }

  "Exercise 7" should "add the numbers of a tree represented by case classes" in {
    import Chapter14.Ex07.{Leaf, Node}

    Ex07.leafSum(Node()) shouldBe 0
    Ex07.leafSum(Leaf(10)) shouldBe 10
    Ex07.leafSum(Node(Leaf(2), Leaf(0), Leaf(5))) shouldBe 7
    Ex07.leafSum(Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5)))) shouldBe 18
  }

  "Exercise 8" should "add the numbers of a tree represented by case classes with operators" in {
    import Chapter14.Ex08._

    Ex08.eval(Node(Sum,
      Node(Mul, Leaf(3), Leaf(8)),
      Leaf(2),
      Node(Sub, Leaf(5)))) shouldBe 21
  }

  "Exercise 9" should "compute the sum of non-None values in a List[Option[Int]]" in {
    Ex09.compute(List()) shouldBe 0
    Ex09.compute(List(None)) shouldBe 0
    Ex09.compute(List(Some(4))) shouldBe 4
    Ex09.compute(List(Some(2), None, None)) shouldBe 2
    Ex09.compute(List(Some(1), Some(2), Some(3))) shouldBe 6
  }

  "Exercise 10" should "compose two functions with a certain type and yield a new one with the same type" in {
    def f(x: Double) = if (x >= 0) Some(sqrt(x)) else None

    def g(x: Double) = if (x != 1) Some(1 / (x - 1)) else None

    val h = Ex10.compose(f, g)

    h(2) shouldBe Some(1)
    h(0) shouldBe None
  }

}
