package Chapter10

trait CryptoLogger {
  val key: Int = 3

  def cypher(input: String): String = {
    input.map(cryptoChar).mkString
  }

  private def cryptoChar(c: Char): Char = {
    if (c.isLetter) (((c - 'a' + key) % 26) + 'a').toChar
    else c
  }
}

case class Exercise4Logger() extends CryptoLogger

case class Exercise4Logger10Key() extends CryptoLogger {
  override val key = 10
}