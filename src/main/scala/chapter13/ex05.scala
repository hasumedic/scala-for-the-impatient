package chapter13

object Ex05 {

  def reduceLeftString(input: List[String], separator: String = " "): String = input.reduceLeft {
    (acc, word) => s"$acc$separator$word"
  }

}
