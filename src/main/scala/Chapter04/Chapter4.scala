package Chapter04

import java.util.{Calendar, Scanner}

import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.{SortedMap, mutable}

object Chapter4 {

  private def getFileWithName(filename: String): java.io.File = {
    new java.io.File(getClass.getResource("/" + filename).getFile)
  }

  def exercise1(gizmos: Map[String, Double]): Map[String, Double] = {
    def tenPercentDiscount(value: Double): Double = {
      math.round(value - value * 10 / 100)
    }

    for ((k, v) <- gizmos) yield (k, tenPercentDiscount(v))
  }

  def exercise2(filename: String): mutable.Map[String, Int] = {
    var map = mutable.Map[String, Int]()
    var word: String = ""
    val in = new Scanner(getFileWithName(filename))
    while (in.hasNext) {
      word = in.next()
      map += (word -> (map.getOrElse(word, 0) + 1))
    }
    map
  }

  def exercise3(filename: String): Map[String, Int] = {
    var map = Map[String, Int]()
    var word: String = ""
    val in = new Scanner(getFileWithName(filename))
    while (in.hasNext) {
      word = in.next()
      map = map + (word -> (map.getOrElse(word, 0) + 1))
    }
    map
  }

  def exercise4(filename: String): SortedMap[String, Int] = {
    var map = SortedMap[String, Int]()
    var word: String = ""
    val in = new Scanner(getFileWithName(filename))
    while (in.hasNext) {
      word = in.next()
      map = map + (word -> (map.getOrElse(word, 0) + 1))
    }
    map foreach println
    map
  }

  //Exercise 5: Haven't bothered with Java backwards compat on TreeMaps

  def exercise6(): mutable.LinkedHashMap[String, Int] = {
    mutable.LinkedHashMap(
      "Monday" -> Calendar.MONDAY,
      "Tuesday" -> Calendar.TUESDAY,
      "Wednesday" -> Calendar.WEDNESDAY,
      "Thursday" -> Calendar.THURSDAY,
      "Friday" -> Calendar.FRIDAY,
      "Saturday" -> Calendar.SATURDAY,
      "Sunday" -> Calendar.SUNDAY
    )
  }


  def exercise7(): Unit = {

    def longestPropertyLenght: Int = {
      val properties = System.getProperties

      var max = 0
      val it = properties.keys()
      while (it.hasMoreElements) {
        max = math.max(max, it.nextElement.toString.length)
      }
      max
    }

    def printProperty(p: (AnyRef, AnyRef)): Unit = {
      println(p._1.toString.padTo(longestPropertyLenght, " ").mkString + " | " + p._2.toString)
    }

    System.getProperties.foreach(p => printProperty(p))
  }

  def exercise8(input: Array[Int]): (Int, Int) = {
    if (input.isEmpty) throw new IllegalArgumentException
    else (input.min, input.max)
  }

  def exercise9(input: Array[Int], v: Int): (Int, Int, Int) = {
    if (input.isEmpty) throw new IllegalArgumentException
    else (input.count(_ < v), input.count(_ == v), input.count(_ > v))
  }

  //Exercise 10
  // In cryptography algorithms it might make sense to map the characters in the sequence with a particular key
}
