package Chapter09

import java.io.{FileInputStream, ObjectInputStream, FileOutputStream, ObjectOutputStream}

import scala.collection.mutable.ArrayBuffer

class Person(val name: String) extends Serializable {
  private var friends: ArrayBuffer[Person] = ArrayBuffer()

  def makeFriendsWith(another: Person): Unit = {
    if (!isFriendsWith(another)) {
      friends += another
    }
  }

  def isFriendsWith(another: Person): Boolean = {
    friends.contains(another)
  }
}

object Serialization extends App {
  val Gustav = new Person("Gustav")
  val Maria = new Person("Maria")
  val Dietrich = new Person("Dietrich")

  Gustav.makeFriendsWith(Maria)
  Maria.makeFriendsWith(Gustav)

  val personArray = Array(Gustav, Maria, Dietrich)

  val file = java.io.File.createTempFile("serialized", "object")
  val out = new ObjectOutputStream(new FileOutputStream(file.getName))
  out.writeObject(personArray)
  out.close()

  val in = new ObjectInputStream(new FileInputStream(file.getName))
  val savedArray = in.readObject().asInstanceOf[Array[Person]]

  savedArray.foreach(person => println(person.name))
  val savedGustav = savedArray(0)
  val savedMaria = savedArray(1)
  val savedDietrich = savedArray(2)

  println(savedGustav isFriendsWith savedMaria)
  println(savedGustav isFriendsWith savedDietrich)
  println(savedMaria isFriendsWith savedGustav)
  println(savedMaria isFriendsWith savedDietrich)
}