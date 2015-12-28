package Chapter8

abstract class Item {
  def price: Double

  def description: String
}

class SimpleItem(itemPrice: Double, itemDescription: String) extends Item {
  override val price = itemPrice
  override val description = itemDescription
}

class Bundle extends Item {
  var itemList: List[Item] = List()

  def addItem(item: Item): Unit = itemList = itemList :+ item

  override def price: Double = {
    itemList.foldLeft(0.0)((accum, item) => accum + item.price)
  }

  override def description: String = {
    itemList.foldLeft("")((accum, item) => accum + item.description + "\n")
  }
}