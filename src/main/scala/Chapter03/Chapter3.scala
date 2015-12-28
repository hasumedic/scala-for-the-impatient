package Chapter03

import java.awt.datatransfer.{DataFlavor, SystemFlavorMap}

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Chapter3 {

  //Exercise 1
  // Write a code snippet that sets a to an array of n random integers between 0 (inclusive) and n (exclusive)
  def exercise1(size: Int): Array[Int] = {
    val a = for (i <- 0 until size) yield util.Random.nextInt(size)
    a.toArray
  }

  //Exercise 2
  // Write a loop that swaps adjacent elements of an array of integers. For example, Array(1, 2, 3, 4, 5) becomes
  // Array(2, 1, 4, 3, 5)
  def exercise2(array: Array[Int]): Array[Int] = {
    for (i <- array.indices if i % 2 != 0) {
      val temp = array(i)
      array(i) = array(i - 1)
      array(i - 1) = temp
    }
    array
  }

  //Exercise 3
  // Repeat the preceding assignment, but produce a new array with the swapped values. Use for/yield
  def exercise3(array: Array[Int]): Array[Int] = {
    (for (i <- array.indices) yield {
      if (i % 2 == 0 && i == array.length - 1) array(i)
      else if (i % 2 == 0) array(i + 1)
      else array(i - 1)
    }).toArray
  }

  //Exercise 4
  // Given an array of integers, produce a new array that contains all positive values of the original array, in their
  // original order, followed by all values that are zero or negative in their original order
  def exercise4(array: Array[Int]): Array[Int] = {
    array.filter(_ > 0) ++ array.filter(_ <= 0)
  }

  //Exercise 5
  // How do you compute the average of an Array[Double]?
  def exercise5(array: Array[Double]): Double = {
    if (array.isEmpty) 0
    else array.sum / array.length
  }

  //Exercise 6
  // How do you rearrange the elements of an Array[Int] so that they appear in reverse sorted order?
  // How do you do the same with an ArrayBuffer[Int]?
  def exercise6Array(array: Array[Int]): Array[Int] = array.sorted.reverse

  def exercise6ArrayBuffer(buffer: ArrayBuffer[Int]): ArrayBuffer[Int] = buffer.sorted.reverse

  //Exercise 7
  // Write a code snippet that produces all values from an array with duplicates removed
  def exercise7[T](array: Array[T]): Array[T] = array.distinct

  //Exercise 8
  // Rewrite the example at the end of Section 3.4, "Transforming Arrays". Collect indexes of the negative elements,
  // reverse the sequence, drop the last index, and call a.remove(i) for each index.
  def exercise8(array: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    val indexes = for (i <- array.indices if array(i) < 0) yield i
    val indexesLessFirstNegative = indexes.reverse.dropRight(1)
    for (j <- indexesLessFirstNegative.indices) {
      array.remove(indexesLessFirstNegative(j))
    }
    array
  }

  //Exercise 9
  // Make a collection of all time zones returned by java.util.Timezone.getAvailableIDs that are in America.
  // Strip off the "America/" prefix and sort the result
  def exercise9(): Array[String] = {
    val prefixLookup = "America/"
    val timezones = java.util.TimeZone.getAvailableIDs
    (for (timezone <- timezones if timezone.startsWith(prefixLookup)) yield {
      timezone.stripPrefix(prefixLookup)
    }).sorted
  }

  //Exercise 10
  // Import java.awt.datatransfer._ and make an object of type SystemFlavorMap with the call
  // val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
  // Then call the getNativesForFlavor method with parameter DataFlavor.imageFlavor and get the return value as a
  // Scala buffer
  def exercise10(): mutable.Buffer[String] = {
    val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
    val natives: mutable.Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
    natives
  }
}

