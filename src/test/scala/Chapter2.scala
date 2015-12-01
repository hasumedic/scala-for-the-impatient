import org.scalatest.{Matchers, FlatSpec}

class Chapter2Spec extends FlatSpec with Matchers {

  "sigsum" should "return -1 on negative numbers" in {
    Chapter2.signum(-1) should be(-1)
    Chapter2.signum(-2) should be(-1)
    Chapter2.signum(-3) should be(-1)
    Chapter2.signum(-10) should be(-1)
    Chapter2.signum(-10L) should be(-1)
  }

  "sigsum" should "return 0 on zero value" in {
    Chapter2.signum(0) should be(0)
  }

  "sigsum" should "return 1 on positive numbers" in {
    Chapter2.signum(1) should be(1)
    Chapter2.signum(2) should be(1)
    Chapter2.signum(3) should be(1)
    Chapter2.signum(10) should be(1)
    Chapter2.signum(10L) should be(1)
  }

  "unicodeProduct" should "return the product of all letters in a string" in {
    Chapter2.unicodeProduct("Hello") should be(9415087488L)
  }

  "unicodeProductNoLoop" should "return the product of all letters in a string" in {
    Chapter2.unicodeProductNoLoop("Hello") should be(9415087488L)
  }

  "product" should "return the product of all letters in a string" in {
    Chapter2.product("Hello") should be(9415087488L)
  }

  "recursiveProduct" should "return the product of all letters in a string" in {
    Chapter2.recursiveProduct("Hello") should be(9415087488L)
  }

  "pow" should "compute the power of numers to a given integer" in {
    Chapter2.pow(0, 0) should be(1)
    Chapter2.pow(1, 0) should be(1)
    Chapter2.pow(-1, 0) should be(1)

    Chapter2.pow(0, 2) should be(0)
    Chapter2.pow(2, 4) should be(16)
    Chapter2.pow(-1, 6) should be(1)

    Chapter2.pow(0, 1) should be(0)
    Chapter2.pow(4, 3) should be(64)
    Chapter2.pow(-3, 5) should be(-243)

    Chapter2.pow(4, -2) should be(0.0625)
    Chapter2.pow(8, -2) should be(0.015625)
    Chapter2.pow(-2, -1) should be(-0.5)
  }
}
