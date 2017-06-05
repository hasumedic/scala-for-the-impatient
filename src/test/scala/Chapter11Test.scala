import Chapter11._
import org.scalatest.{FlatSpec, Matchers}

class Chapter11Test extends FlatSpec with Matchers {

  "exercise 1" should "test the evaluation of + and -> operators" in {
    // Evaluated left to right
    val x: (Int, Int) = 3 + 4 -> 5

    // Cannot be evaluated without parenthesis, due to the left to right association rule
    //val y = 3 -> 4 + 5
    val y = 3 -> (4 + 5)
  }

  // Exercise 2: Would not respect left associativity

  "exercise 3" should "implement addition of fractions normalizing the result" in {
    (Fraction(1, 2) + Fraction(1, 2)).toString shouldBe "1/1"
    (Fraction(5, 8) + Fraction(2, 8)).toString shouldBe "7/8"
    (Fraction(2, 3) + Fraction(1, 4)).toString shouldBe "11/12"
  }
  it should "implement subtraction of fractions normalizing the result" in {
    (Fraction(5, 8) - Fraction(2, 8)).toString shouldBe "3/8"
    (Fraction(4, 15) - Fraction(1, 2)).toString shouldBe "-7/30"
  }
  it should "implement multiplication of fractions normalizing the result" in {
    (Fraction(2, 3) * Fraction(5, 7)).toString shouldBe "10/21"
    (Fraction(3, 4) * Fraction(7, 11)).toString shouldBe "21/44"
    (Fraction(8, 9) * Fraction(15, 16)).toString shouldBe "5/6"
  }
  it should "implement division of fractions normalizing the result" in {
    (Fraction(14, 20) / Fraction(15, 20)).toString shouldBe "14/15"
    (Fraction(5, 8) / Fraction(7, 8)).toString shouldBe "5/7"
    (Fraction(2, 5) / Fraction(3, 4)).toString shouldBe "8/15"
  }

  "exercise 4" should "provide a class Money with addition and subtraction methods" in {
    Money(1, 75) + Money(0, 50) shouldBe Money(2, 25)
    Money(1, 75) - Money(0, 50) shouldBe Money(1, 25)

    //Multiplying money by money doesn't really make sense. It'd make sense to multiply it by an integer or a double number, but not by another Money object. Pretty much the same applies to division, but it'd be even worse because it'd need to also resolve a rounding problem.
  }

  "exercise 5" should "provide table operators to generate HTML tables" in {
    (Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET").toString shouldBe "<table><tr><td>Java</td><td>Scala</td></tr><tr><td>Gosling</td><td>Odersky</td></tr><tr><td>JVM</td><td>JVM, .NET</td></tr></table>"
  }

  "exercise 6" should "provide operators to combine ASCIIArt objects horizontally" in {
    (ASCIIArt(CatASCIIArt.get) | ASCIIArt(SaluteASCIIArt.get)).toString shouldBe
      " /\\_/\\     ----- \n" +
        "( ' ' )  / Hello \\\n" +
        "(  -  ) <  Scala |\n" +
        " | | |   \\ Coder /\n" +
        "(__|__)    ----- "
  }
  it should "provide an operator to combine ASCIIArt vertically" in {
    (ASCIIArt(CatASCIIArt.get) / ASCIIArt(SaluteASCIIArt.get)).toString shouldBe
      " /\\_/\\ \n" +
        "( ' ' )\n" +
        "(  -  )\n" +
        " | | | \n" +
        "(__|__)\n" +
        "   ----- \n" +
        " / Hello \\\n" +
        "<  Scala |\n" +
        " \\ Coder /\n" +
        "   ----- "
  }

  "exercise 7" should "implement an apply method to store a sequence of 64 bits contained in a long" in {
    val longValue = 10L
    BitSequence(longValue)(1) shouldBe Zero
    BitSequence(longValue)(2) shouldBe One
    BitSequence(longValue)(3) shouldBe Zero
    BitSequence(longValue)(4) shouldBe One
  }
  it should "provide an update method to change the sign of a bit at a particular position" in {
    val longValue = 3L
    val sequence = BitSequence(longValue)
    sequence(1) shouldBe One
    sequence(1) = Zero
    sequence(1) shouldBe Zero
  }

  "exercise 8" should "prevent from constructing non-sensical matrix" in {
    intercept[IllegalArgumentException] {
      Matrix(Vector())
    }
    intercept[IllegalArgumentException] {
      Matrix(Vector(Vector()))
    }
    intercept[IllegalArgumentException] {
      Matrix(Vector(Vector(1, 2), Vector()))
    }
    intercept[IllegalArgumentException] {
      Matrix(Vector(Vector(1), Vector(1, 2)))
    }
  }
  it should "provide a constructor that allows for matrix of any size" in {
    val square = Matrix(Vector(Vector(1, 2)))
    assert(square.isInstanceOf[Matrix])
    val rectangle = Matrix(Vector(Vector(1, 2), Vector(2, 1)))
    assert(rectangle.isInstanceOf[Matrix])
    val strip = Matrix(Vector(Vector(1, 2, 3), Vector(3, 2, 1)))
    assert(strip.isInstanceOf[Matrix])
  }
  it should "provide a plus method" in {
    val lowSquare = Matrix(Vector(Vector(1)))
    val highSquare = Matrix(Vector(Vector(10)))
    val sumOfSquares = lowSquare + highSquare
    assert(sumOfSquares.contains(Matrix(Vector(Vector(11)))))
  }
  it should "not add matrices of different size" in {
    val aMatrix = Matrix(Vector(Vector(10, 2)))
    val anotherMatrix = Matrix(Vector(Vector(1)))
    assert((aMatrix + anotherMatrix).isEmpty)
  }
  it should "provide a multiply method" in {
    val aRectangle = Matrix(Vector(Vector(1, 2, 3)))
    val anotherRectangle = Matrix(Vector(Vector(1, 2, 3)))
    assert((aRectangle * anotherRectangle).contains(Matrix(Vector(Vector(1, 4, 9)))))
  }
  it should "provide an Integer multiply method" in {
    val aRectangle = Matrix(Vector(Vector(2, 2, 2), Vector(1, 1, 1)))
    assert((aRectangle * 2) == Matrix(Vector(Vector(4, 4, 4), Vector(2, 2, 2))))
  }
  it should "provide an accessor via its coordinates" in {
    val aLongMatrix = Matrix(Vector(Vector(1, 2, 3, 4, 5, 6, 7, 8)))
    assert(aLongMatrix(0, 5).contains(6))
  }
  it should "disregard indexes out of range" in {
    val aRowMatrix = Matrix(Vector(Vector(1, 2)))
    assert(aRowMatrix(1, 2).isEmpty)

    val matrix = Matrix(Vector(Vector(1, 2, 3), Vector(4, 5, 6)))
    assert(matrix(5, 10).isEmpty)
  }

  "exercise 9" should "extract the path, filename and extension from a complete path" in {

    val fullNames = Map(
      new RichFile("/home/cay/readme.txt") -> Some("/home/cay", "readme", "txt"),
      new RichFile("/etc/apache2/conf/httpd.conf") -> Some("/etc/apache2/conf", "httpd", "conf")
    )

    fullNames.foreach {
      case (file, expected) => RichFile.unapply(file) shouldBe expected
    }
  }

  "exercise 10" should "extract each element of the full path in a sequence of strings" in {
    import Chapter11.Exercise10.RichFile

    val fullNames = Map(
      new RichFile("/home/cay/readme.txt") -> Some(Seq("home", "cay", "readme.txt")),
      new RichFile("/etc/apache2/conf/httpd.conf") -> Some(Seq("etc", "apache2", "conf", "httpd.conf"))
    )

    fullNames.foreach {
      case (file, expected) => RichFile.unapplySeq(file) shouldBe expected
    }
  }

}
