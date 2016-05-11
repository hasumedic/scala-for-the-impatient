package Chapter10

trait RectangleLike {
  def translate(x: Int, y: Int): RectangleLike

  def grow(x: Int, y: Int): RectangleLike
}
