import Chapter16.{ex07, ex08, ex09}
import org.scalatest.{FlatSpec, Matchers}

class Chapter16Test extends FlatSpec with Matchers {

  private val map = Map("A" -> "1", "B" -> "2")
  // format: off
  private val descriptionList = <dl><dt>A</dt><dd>1</dd><dt>B</dt><dd>2</dd></dl>
  // format: on

  "Exercise 7" should "provide a function that builds description lists from a Map" in {
    ex07.buildDescriptionList(map) shouldBe descriptionList
  }
  it should "take into account empty maps" in {
    ex07.buildDescriptionList(Map.empty) shouldBe <dl></dl>
  }

  "Exercise 8" should "provide a function that builds a map from a description list" in {
    ex08.buildMapFromDescriptionList(descriptionList) shouldBe map
  }

  "Exercise 9" should "add TODO attribute to images in XHTML document" in {
    val initialDocument = <html xmlns="http://www.w3.org/1999/xhtml">
      <head>
        <title>Some Title</title>
      </head>
      <body>
        <img src="happy.gif" alt="Happy face"/>
        <img src="sad.gif"/>
      </body>
    </html>

    val expectedDocument = <html xmlns="http://www.w3.org/1999/xhtml">
      <head>
        <title>Some Title</title>
      </head>
      <body>
        <img src="happy.gif" alt="Happy face"/>
        <img alt="TODO" src="sad.gif"/>
      </body>
    </html>

    ex09.addTodosToImages(initialDocument).mkString shouldBe expectedDocument.mkString
  }
}
