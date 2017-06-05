package Chapter11

class BitSequence(private var representation: Long) {
  def apply(bit: Int): Bit = if (representation.toBinaryString.reverse.charAt(bit - 1) == '0') Zero else One

  def update(bit: Int, value: Bit): Unit = representation = representation.toBinaryString.updated(bit, if (value == Zero) '0' else '1').toLong
}

object BitSequence {
  def apply(representation: Long): BitSequence = new BitSequence(representation)
}

sealed trait Bit
case object Zero extends Bit
case object One extends Bit
