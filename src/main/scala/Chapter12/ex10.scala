package Chapter12

object Ex10 {

  def unless(condition: => Boolean)(block: => Unit): Unit = {
    if (condition) block
  }
}
