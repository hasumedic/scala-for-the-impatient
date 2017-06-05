package Chapter11

case class Matrix(grid: Vector[Vector[Int]]) {

  require(grid.nonEmpty && allRowsArePopulated && allRowsAreTheSameSize)

  def apply(row: Int, column: Int): Option[Int] = {
    if (grid.isDefinedAt(row) && grid(row).isDefinedAt(column)) Some(grid(row)(column))
    else None
  }

  def sameSize(other: Matrix): Boolean = {
    haveSameSize(other) && allRowsAreTheSameSize(other)
  }

  private def haveSameSize(other: Matrix) = {
    grid.size == other.grid.size
  }

  def +(other: Matrix): Option[Matrix] = {
    operateOnMatricesRows(other, addRows)
  }

  def *(other: Matrix): Option[Matrix] = {
    operateOnMatricesRows(other, multiplyRows)
  }

  def *(multiplier: Int): Matrix = Matrix {
    grid.map(row => multiplyRowBy(row, multiplier))
  }

  private def multiplyRowBy(row: Vector[Int], multiplier: Int): Vector[Int] = {
    row.map(_ * multiplier)
  }

  private def operateOnMatricesRows(other: Matrix, operation: (Vector[Int], Vector[Int]) => Vector[Int]) = {
    if (!sameSize(other)) None
    else {
      Some(Matrix {
        for {
          thisRow <- grid
          otherRow <- other.grid
        } yield operation(thisRow, otherRow)
      })
    }
  }

  private def addRows(firstRow: Vector[Int], secondRow: Vector[Int]): Vector[Int] = {
    (firstRow zip secondRow).map {
      case (x: Int, y: Int) => x + y
    }
  }

  private def multiplyRows(firstRow: Vector[Int], secondRow: Vector[Int]): Vector[Int] = {
    (firstRow zip secondRow).map {
      case (x: Int, y: Int) => x * y
    }
  }

  private def allRowsAreTheSameSize(target: Matrix) = {
    target.grid.forall(_.size == grid.head.size)
  }

  private def allRowsAreTheSameSize: Boolean = {
    grid.forall(_.size == grid.head.size)
  }

  private def allRowsArePopulated: Boolean = {
    grid.forall(_.nonEmpty)
  }
}