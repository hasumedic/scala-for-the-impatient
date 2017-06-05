package Chapter11

case class ASCIIArt(art: Seq[String]) {

  def |(other: ASCIIArt): ASCIIArt = {

    val newArt = (this.art zip other.art).map {
      case (x: String, y: String) => s"$x $y"
    }

    ASCIIArt(newArt)
  }

  def /(other: ASCIIArt): ASCIIArt = {
    ASCIIArt(this.art ++ other.art)
  }

  def print(): Unit = {
    art foreach println
  }

  override def toString: String = {
    art.mkString("\n")
  }
}

object CatASCIIArt {

  def get: Seq[String] = Seq(
    " /\\_/\\ ",
    "( ' ' )",
    "(  -  )",
    " | | | ",
    "(__|__)"
  )
}

object SaluteASCIIArt {
  def get: Seq[String] = Seq(
    "   ----- ",
    " / Hello \\",
    "<  Scala |",
    " \\ Coder /",
    "   ----- "
  )
}

