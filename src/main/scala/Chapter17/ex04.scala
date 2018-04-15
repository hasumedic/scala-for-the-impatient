package Chapter17

object ex04 extends App {

  class Person(name: String)
  class Student(studentName: String) extends Person(studentName)

  class Pair[T](val first: T, val second: T) {
    def replaceFirst(newFirst: T) = new Pair[T](newFirst, second)

    override def toString: String = s"[$first, $second]"
  }

  val pair = new Pair(new Person("Me"), new Person("Other"))
  val differentPair = pair.replaceFirst(new Student("Son"))

  println(pair)
  println(differentPair)

  //BUT!

  // val anotherPair = new Pair(new Student("Bad"), new Student("Good"))
  // val changedPair = anotherPair.replaceFirst(new Person("ERROR"))

  // In the eyes of the compiler, any Student is a Person. It doesn't work the other way around.
}
