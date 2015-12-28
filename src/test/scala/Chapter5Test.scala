import Chapter5._
import org.scalatest.{Matchers, FlatSpec}

class Chapter5Test extends FlatSpec with Matchers {

  "exercise 1" should "not go negative when incrementing after maxInt" in {
    val counter = new CounterExercise1
    for (i <- 0 until Int.MaxValue) {
      counter.increment()
    }
    counter.increment()
    counter.current() should be(Int.MaxValue.toFloat + 1)
  }

  "exercise 3" should "not allow the construction of invalid times" in {
    intercept[IllegalArgumentException] {
      new Time(-4, 15)
    }
    intercept[IllegalArgumentException] {
      new Time(24, 15)
    }
    intercept[IllegalArgumentException] {
      new Time(0, -4)
    }
    intercept[IllegalArgumentException] {
      new Time(10, 61)
    }
  }

  "exercise 3" should "successfully determine if a time is greater than another" in {
    val morning = new Time(7, 45)
    val midday = new Time(12, 0)
    val afternoon = new Time(15, 30)
    val evening = new Time(19, 15)
    val midnight = new Time(0, 0)

    morning.before(midday) should be(true)
    midday.before(afternoon) should be(true)
    afternoon.before(evening) should be(true)
    evening.before(midnight) should be(false)
    midnight.before(morning) should be(true)

    evening.before(afternoon) should be(false)
    morning.before(midnight) should be(false)
    afternoon.before(morning) should be(false)
    midday.before(midnight) should be(false)
  }

  "exercise 3" should "not determine the same time to be before another" in {
    new Time(6, 45).before(new Time(6, 45)) should be(false)
    new Time(12, 0).before(new Time(12, 0)) should be(false)
    new Time(22, 14).before(new Time(22, 14)) should be(false)
  }

  //Exercise 4 should have exactly the same interface than exercise 3, so same tests apply

  "exercise 4" should "not allow the construction of invalid times" in {
    intercept[IllegalArgumentException] {
      new Time4(-4, 15)
    }
    intercept[IllegalArgumentException] {
      new Time4(24, 15)
    }
    intercept[IllegalArgumentException] {
      new Time4(0, -4)
    }
    intercept[IllegalArgumentException] {
      new Time4(10, 61)
    }
  }

  "exercise 4" should "successfully determine if a time is greater than another" in {
    val morning = new Time4(7, 45)
    val midday = new Time4(12, 0)
    val afternoon = new Time4(15, 30)
    val evening = new Time4(19, 15)
    val midnight = new Time4(0, 0)

    morning.before(midday) should be(true)
    midday.before(afternoon) should be(true)
    afternoon.before(evening) should be(true)
    evening.before(midnight) should be(false)
    midnight.before(morning) should be(true)

    evening.before(afternoon) should be(false)
    morning.before(midnight) should be(false)
    afternoon.before(morning) should be(false)
    midday.before(midnight) should be(false)
  }

  "exercise 4" should "not determine the same time to be before another" in {
    new Time4(6, 45).before(new Time4(6, 45)) should be(false)
    new Time4(12, 0).before(new Time4(12, 0)) should be(false)
    new Time4(22, 14).before(new Time4(22, 14)) should be(false)
  }

  "exercise 5" should "implement a JavaBeans class Chapter5.Student" in {
    val student = new Student(15L, "James")
    student.getId should be(15)
    student.getName should be("James")

    student.setId(25L)
    student.getId should be(25)

    student.setName("Michael")
    student.getName should be("Michael")
  }

  "exercise 6" should "provide a Chapter5.Person class which accepts negative ages and turns them into 0" in {
    val person = new Person(-10)
    person.age should be(0)
  }

  "exercise 7" should "provide a Chapter5.Person with a name + surname constructor and read only access methods" in {
    val person = new Person7("Alan Smith")
    person.firstName should be("Alan")
    person.lastName should be("Smith")
  }

  "exercise 8" should "provide a Chapter5.Car specifying manufacturer and model" in {
    val car = new Car("Opel", "Astra")
    car.manufacturer should be("Opel")
    car.model should be("Astra")
  }
  "exercise 8" should "provide a Chapter5.Car given a manufacturer, model, year and plate" in {
    val car = new Car("Opel", "Corsa", 2001, "OC2001")
    car.manufacturer should be("Opel")
    car.model should be("Corsa")
    car.year should be(2001)
    car.plate should be("OC2001")
  }
  "exercise 8" should "provide default values for non-mandatory Chapter5.Car parameters" in {
    val car = new Car("Opel", "Meriva")
    car.manufacturer should be("Opel")
    car.model should be("Meriva")
    car.year should be(-1)
    car.plate should be("")
  }
}
