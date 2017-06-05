package Chapter11

case class Table() {
  private var rows: Seq[Row] = Nil
  private var currentRow: Row = Row()

  def |(content: String): Table = {
    currentRow + Cell(content)
    this
  }

  def ||(content: String): Table = {
    stashCurrentRow()
    |(content)
  }

  private def stashCurrentRow(): Unit = {
    rows = rows :+ currentRow
    currentRow = Row()
  }

  override def toString: String = {
    stashCurrentRow()
    "<table>" + rows.map(_.toString).mkString + "</table>"
  }
}

case class Row() {
  private var rowContent: Seq[Cell] = Seq()

  def +(cell: Cell): Unit = rowContent = rowContent :+ cell

  override def toString: String = "<tr>" + rowContent.map(element => s"<td>${element.content}</td>").mkString + "</tr>"
}

case class Cell(content: String)
