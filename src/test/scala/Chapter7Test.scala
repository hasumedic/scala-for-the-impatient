import java.util

import org.scalatest.{Matchers, FlatSpec}

class Chapter7Test extends FlatSpec with Matchers {
  "exercise 2" should "hold same value in different packages with com" in {
    assert(Chapter7.exercise2.outside == _root_.Chapter7.com.Chapter7.exercise2.inside)
  }

  "exercise 3" should "define a deterministic number generator based on a seed" in {
    import Chapter7.random._
    val generator = RandomNumberGenerator
    generator.setSeed(1)

    val firstExpected = 1015568748
    assert(firstExpected == generator.nextInt)

    val secondExpected = 1586005467
    assert(secondExpected == generator.nextInt)

    val thirdExpected = -2129264258
    assert(thirdExpected == generator.nextInt)
  }

  "exercise 6" should "should convert empty Java HashMap into an empty Scala HashMap" in {
    val converter = Chapter7.HashMapConverter
    val emptyJava = new util.HashMap[String, Int]()
    val emptyScala = new scala.collection.immutable.HashMap[String, Int]()

    assert(converter.fromJavaToScala(emptyJava) == emptyScala)
  }
  "exercise 6" should "should convert any Java HashMap into a Scala HashMap" in {
    val converter = Chapter7.HashMapConverter
    val javaMap = new util.HashMap[String, Int](3)
    javaMap.put("one", 1)
    javaMap.put("two", 2)
    javaMap.put("three", 3)
    val scalaMap = scala.collection.immutable.HashMap[String, Int]("one" -> 1, "two" -> 2, "three" -> 3)

    converter.fromJavaToScala(javaMap) should contain theSameElementsAs scalaMap
  }
}
