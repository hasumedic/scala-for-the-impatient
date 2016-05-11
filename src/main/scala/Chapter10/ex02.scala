package Chapter10

import java.awt.Point

class OrderedPoint(x: Int, y: Int) extends Point(x, y) with scala.math.Ordered[Point] {

  override def compare(that: Point): Int =
    if (this.x < that.x || (this.x >= that.x && this.y < that.y)) -1
    else if (this.x == that.x && this.y == that.y) 0
    else 1
}
