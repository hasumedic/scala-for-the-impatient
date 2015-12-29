import Chapter09._
import org.scalatest.{Matchers, FlatSpec}

import scala.io.Source

class Chapter9Test extends FlatSpec with Matchers {

  "exercise 1" should "revert the lines of a file" in {
    val reverter = new LineReverter(Source.fromURL(getClass.getResource("/Chapter09-01.txt")))
    val expected = "Line 3\n" + "Line 2\n" + "Line 1"
    reverter.revert should be(expected)
  }

  "exercise 2" should "transform a file with tabs into another without them" in {
    val remover = new TabRemover(Source.fromURL(getClass.getResource("/Chapter09-02.txt")))
    val path = remover.remove()

    val expected = "class Example {\n" +
      "    private lazy val first = 1\n" +
      "    private lazy val second = 'a'\n" +
      "\n" +
      "    def myFunction: String = {\n" +
      "        \"Hello World!\"\n" +
      "    }\n" +
      "}\n"
    Source.fromFile(path.toFile).mkString should be(expected)
  }

  "exercise 3" should "detect words longer than 12 characters in a piece of text in a file" in {
    val detector = new LongWordDetector(Source.fromURL(getClass.getResource("/Chapter09-03.txt")))
    val expected = Array("energetically", "incredulously")

    detector.detect() should be(expected)
  }

  "exercise 4" should "calculate the sum, avg, maximum and minimum of a floating point number's file" in {
    val calculator = new FloatingPointCalculator(Source.fromURL(getClass.getResource("/Chapter09-04.txt")))
    val expected = CalculatorResults(389.55, 38.955, 100.00, 1.43)
    calculator.calculate should be(expected)
  }

  "exercise 5" should "print the powers of 2 and their reciprocals in a column based file" in {
    val printer = new PowerPrinter()
    val path = printer.print
    Source.fromFile(path.toFile).mkString should be equals ("1\t1\n" +
      "2\t0.5\n" +
      "4\t0.25\n" +
      "8\t0.125\n" +
      "16\t0.0625\n" +
      "32\t0.03125\n" +
      "64\t0.015625\n" +
      "128\t0.0078125\n" +
      "256\t0.00390625\n" +
      "512\t0.001953125\n" +
      "1024\t0.0009765625\n" +
      "2048\t0.00048828125\n" +
      "4096\t0.000244140625\n" +
      "8192\t0.0001220703125\n" +
      "16384\t0.00006103515625\n" +
      "32768\t0.00003051757813\n" +
      "65536\t0.00001525878907\n" +
      "131072\t0.00000762939454\n" +
      "262144\t0.00000381469727\n" +
      "524288\t0.00000190734864\n"
      )
  }

  "exercise 6" should "print all quoted strings within a file" in {
    val printer = new QuotePrinter(Source.fromURL(getClass.getResource("Chapter09-06.txt")))
    val quotes = printer.print
    quotes should contain theSameElementsAs Array("Hello", "Single escape", "Double escape")
  }

  "exercise 7" should "print all non-floating point values in a file" in {
    val printer = new NonFloatingPointPrinter(Source.fromURL(getClass.getResource("Chapter09-07.txt")))
    val tokens = printer.print
    tokens should contain theSameElementsAs Array("This", "should", "appear")
  }

  "exercise 8" should "extract every 'src' attribute from image tags in an HTML file" in {
    val locator = new ImageLocator
    val images = locator.locate(Source.fromURL(getClass.getResource("Chapter09-08.html")))
    images.length should be(6)
    images should contain theSameElementsAs Array("images/pic1.jpg", "images/pic2.jpg", "images/pic3.jpg", "images/pic4.jpg", "images/pic5.jpg", "images/pic6.jpg")
  }
}
