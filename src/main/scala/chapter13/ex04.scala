package chapter13

object Ex04 {

  def findIndexesInMap(lookupNames: List[String], referenceMap: Map[String, Int]): Array[Int] = lookupNames.flatMap(referenceMap.get).toArray
  
}
