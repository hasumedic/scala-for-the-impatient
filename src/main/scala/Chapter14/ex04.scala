package Chapter14

object Ex04 {

  sealed abstract class Item
  case class Article(description: String, price: Double) extends Item
  case class Bundle(description: String, discount: Double, items: Item*) extends Item
  case class Multiple(amount: Int, item: Item) extends Item

  def price(item: Item): Double = item match {
    case Article(_, price) => price
    case Bundle(_, discount, items @ _*) => items.map(price).sum - discount
    case Multiple(amount, items) => price(items) * amount
  }

}
