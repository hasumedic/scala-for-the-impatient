package Chapter10

class Person(val name: String)


// layered traits
trait Greeter {
  def greet(someone: String): String = {
    s"Hello $someone!"
  }
}

trait Shouter extends Greeter {
  override def greet(someone: String): String = {
    super.greet(someone.toUpperCase)
  }
}

trait Quieter extends Greeter {
  override def greet(someone: String): String = {
    super.greet(someone.toLowerCase)
  }
}

// concrete and abstract methods
trait Boxer {
  type Hit = Boolean
  def punch: Hit
  def kick: Hit
}

trait NoArmedBoxer extends Boxer {
  abstract override def punch: Hit = super.punch
  abstract override def kick: Hit = super.kick
}

trait NoLeggedBoxer extends Boxer {
  override def punch: Hit = true
  override def kick: Hit = false
}

// concrete and abstract fields
trait Jumper {
  val jumpCapacity: Int
  def jump(gap: Int): Boolean = {
    jumpCapacity - gap >= 0
  }
}

trait LongJumper extends Jumper {
  val jumpCapacity: Int = 10
}

trait ShortJumper extends Jumper {
  val jumpCapacity: Int = 5
}