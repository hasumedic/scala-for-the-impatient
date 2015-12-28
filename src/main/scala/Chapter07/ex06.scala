package Chapter07

import java.util
import java.util.{HashMap => JavaHashMap}
import scala.collection.immutable.{HashMap => ScalaHashMap}

object HashMapConverter {
  def fromJavaToScala[T, U](javaHashMap: JavaHashMap[T, U]): ScalaHashMap[T, U] = {

    def fillMap[T, U](mapIterator: util.Iterator[util.Map.Entry[T, U]], scalaHashMap: ScalaHashMap[T, U]): ScalaHashMap[T, U] = {
      if (!mapIterator.hasNext) scalaHashMap
      else {
        val next = mapIterator.next()
        fillMap(mapIterator, scalaHashMap + (next.getKey -> next.getValue))
      }
    }

    fillMap(javaHashMap.entrySet.iterator, ScalaHashMap())
  }
}
