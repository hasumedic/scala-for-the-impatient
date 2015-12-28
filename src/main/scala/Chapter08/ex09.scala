package Chapter08

class Creature {
  def range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class Ant extends Creature {
  override val range = 2
}

// In Scala 2.11.7 this is no longer an issue. It knows that range is going to be initialized with a value and puts it there so env is initialized correctly

