package Chapter8

abstract class Shape {
  def centerPoint: Point
}

class Rectangle(val x: Int, val y: Int) extends Shape {
  override def centerPoint: Point = {
    new Point(x / 2, y / 2)
  }

  final override def equals(other: Any) = {
    val that = other.asInstanceOf[Rectangle]
    if (that == null) false
    else x == that.x && y == that.y
  }
}

class Circle(val radius: Int) extends Shape {
  override def centerPoint: Point = {
    new Point(radius, radius)
  }

  final override def equals(other: Any) = {
    val that = other.asInstanceOf[Circle]
    if (that == null) false
    else radius == that.radius
  }
}