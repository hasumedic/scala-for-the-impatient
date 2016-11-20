import Chapter10._
import org.scalatest.{FlatSpec, Matchers}

//This chapter intentionally skips all Java related exercises

class Chapter10Test extends FlatSpec with Matchers {

  "exercise 1" should "allow a RectangleLike code to compile" in {
    assertCompiles(
      "import Chapter10.RectangleLike\n" +
        "val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike\n" +
        "egg.translate(10, -10)\n" +
        "egg.grow(10, 20)"
    )
  }

  "exercise 2" should "mixin Ordered with Point" in {
    val smallPoint = new OrderedPoint(5, 10)
    val biggerPoint = new OrderedPoint(10, 5)
    val yetABiggerPoint = new OrderedPoint(5, 11)

    assert(smallPoint.compare(biggerPoint) < 0)
    assert(smallPoint.compare(yetABiggerPoint) < 0)
    smallPoint.compare(smallPoint) should be(0)
    assert(yetABiggerPoint.compare(smallPoint) > 0)
  }

  "exercise 4" should "provide a CryptoLogger trait which defaults its key to 3" in {
    val input = "sample text"
    val output = "vdpsoh whaw"
    Exercise4Logger().cypher(input) should be(output)
  }
  it should "provide the possibility to override the default value for the key (10)" in {
    val input = "sample text"
    val output = "ckwzvo dohd"
    Exercise4Logger10Key().cypher(input) should be(output)
  }

  "exercise 7" should "provide with layered traits" in {
    val loudPerson = new Person("Hasu") with Greeter with Shouter with Quieter
    val quietPerson = new Person("Medic") with Greeter with Quieter with Shouter

    loudPerson.greet(quietPerson.name) shouldBe "Hello MEDIC!"
    quietPerson.greet(loudPerson.name) shouldBe "Hello hasu!"
  }
  it should "demonstrate how abstract fields work with jumps" in {
    val longJumper = new Person("Mark") with Jumper with LongJumper
    val shortJumper = new Person("John") with Jumper with ShortJumper
    longJumper.jump(6) shouldBe true
    shortJumper.jump(6) shouldBe false
  }
}
