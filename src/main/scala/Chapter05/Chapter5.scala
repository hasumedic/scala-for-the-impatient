package Chapter05

object Chapter5

//Exercise 1
class CounterExercise1 {
  private var value = 0L

  def increment() {
    value += 1
  }

  def current() = value
}

//Exercise 2
class BankAccount {
  private var internalBalance = 0

  def balance = internalBalance

  def deposit(amount: Int) = internalBalance += amount

  def withdraw(amount: Int) = internalBalance -= amount
}

//Exercise 3
class Time(private val hrs: Int, private val min: Int) {
  require(hrs >= 0 && hrs < 24)
  require(min >= 0 && min < 60)

  def hours = hrs

  def minutes = min

  def before(other: Time): Boolean = {
    if (this.hours == other.hours) this.min < other.min
    else this.hours < other.hours
  }
}

//Exercise 4
class Time4(private val hrs: Int, private val min: Int) {
  require(hrs >= 0 && hrs < 24)
  require(min >= 0 && min < 60)

  private val numberOfMinutes = (hrs * 60) + min

  def hours = hrs

  def minutes = min

  def before(other: Time4): Boolean = {
    this.numberOfMinutes < other.numberOfMinutes
  }
}

//Exercise 5
import scala.beans.BeanProperty

class Student(@BeanProperty var id: Long, @BeanProperty var name: String)

//Exercise 6
class Person(private val _age: Int) {
  def age = if (_age < 0) 0 else _age
}

//Exercise 7
class Person7(fullName: String) {
  private val name = fullName.split(" ").take(1).mkString
  private val surname = fullName.split(" ").takeRight(1).mkString

  def firstName = name

  def lastName = surname
}

//Exerise 8
class Car(val manufacturer: String, val model: String, val year: Int = -1, var plate: String = "")

//Exercise 10
class Employee {
  private var _name: String = "John Q. Public"
  var salary = 0.0

  def name = _name

  def this(name: String, s: Double) {
    this()
    _name = name
    salary = s
  }
}