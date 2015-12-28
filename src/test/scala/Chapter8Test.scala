import Chapter08._
import org.scalatest.{Matchers, FlatSpec}

class Chapter8Test extends FlatSpec with Matchers {

  "exercise 1" should "provide an extended Chapter5.BankAccount that charges 1$ commission per operation" in {
    val account = new CheckingAccount(10)
    account.deposit(10)
    account.currentBalance should be(19)
    account.withdraw(5)
    account.currentBalance should be(13)
  }

  "exercise 2" should "extend Chapter5.BankAccount to a SavingsAccount that gives 1% interest every month" in {
    val account = new SavingsAccount(50)
    account.earnMonthlyInterest()
    account.currentBalance should be(50.50)
  }
  "exercise 2" should "give 3 deposits or withdrawals for free every month" in {
    val account = new SavingsAccount(80)
    account.deposit(10)
    account.deposit(10)
    account.withdraw(10)
    account.currentBalance should be(90)
  }
  "exercise 2" should "charge commission after the third operation on the same month" in {
    val account = new SavingsAccount(10)
    account.deposit(10)
    account.deposit(10)
    account.withdraw(10)
    account.withdraw(10)
    account.earnMonthlyInterest()
    account.currentBalance should be(9.09)
  }
  "exercise 2" should "reset commission charge after calculating month interest" in {
    val account = new SavingsAccount(50)
    account.deposit(10)
    account.deposit(10)
    account.deposit(10)
    account.earnMonthlyInterest()
    account.withdraw(10)
    account.withdraw(10)
    account.withdraw(10)
    account.currentBalance should be(50.80)
  }

  "exercise 3" should "implement a hierarchy of books and cds" in {
    val book = new BookProduct("Book", "Alex", "Salguero", 10.00, 1000)
    book.summaryLine should be("Book ( Salguero, Alex ): page count - 1000")

    val cd = new CdProduct("CD", "Alex", "Salguero", 10.00, 500)
    cd.summaryLine should be("CD ( Salguero, Alex ): playing time - 500")
  }

  "exercise 4" should "implement a SimpleItem that overrides Item price and description" in {
    val simpleItem = new SimpleItem(10.00, "Little toy")
    simpleItem.price should be(10.00)
    simpleItem.description should be("Little toy")
  }
  "exercise 4" should "implement a Bundle that represents many Items" in {
    val bundle = new Bundle()
    bundle.addItem(new SimpleItem(5.00, "Mirror"))
    bundle.addItem(new SimpleItem(15.00, "Book"))
    bundle.addItem(new SimpleItem(10.00, "Pen"))
    bundle.price should be(30.00)
    bundle.description should be("Mirror\nBook\nPen\n")
  }

  "exercise 5" should "implement a concrete class Point which takes x and y in its constructor" in {
    val point = new Point(10, 5)
    point.x should be(10)
    point.y should be(5)
  }
  "exercise 5" should "implement a LabeledPoint that extends Point with a label parameter in its signature" in {
    val labeledPoint = new LabeledPoint("Black Thursday", 1929, 230.07)
    labeledPoint.x should be(1929)
    labeledPoint.y should be(230.07)
    labeledPoint.label should be("Black Thursday")
  }

  "exercise 6" should "implement a rectangle class that calculates its centre point" in {
    val rectangle = new Rectangle(10, 4)
    rectangle.isInstanceOf[Shape] should be(true)
    val center = new Point(5, 2)
    rectangle.centerPoint should be equals center
  }
  "exercise 6" should "implement a circle class that calculates its centre point" in {
    val circle = new Circle(5)
    circle.isInstanceOf[Shape] should be(true)
    val center = new Point(5, 5)
    circle.centerPoint should be equals center
  }

  "exercise 7" should "provide a Square class extending Rectangle which constructs from a corner point and a width" in {
    val square = new Square(6, 6, 5)
    square.isInstanceOf[java.awt.Rectangle] should be(true)
    square.getLocation should be equals new Point(6, 6)
    square.getWidth should be(5)
    square.getHeight should be(5)
  }
  "exercise 7" should "provide a Square class extending Rectangle which constructs from a width defaulting corner point to 0" in {
    val square = new Square(7)
    square.isInstanceOf[java.awt.Rectangle] should be(true)
    square.getLocation should be equals new Point(0, 0)
    square.getWidth should be(7)
    square.getHeight should be(7)
  }
  "exercise 7" should "provide a Square class extending Rectangle which constructs defaulting everything to 0" in {
    val square = new Square
    square.isInstanceOf[java.awt.Rectangle] should be(true)
    square.getLocation should be equals new Point(0, 0)
    square.getWidth should be(0)
    square.getHeight should be(0)
  }
}
