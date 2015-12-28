package Chapter8

// This is a little hierarchy that describes products from a Shop that can be either a CD or a Book

class ShopProduct(title: String, producerFirstName: String, producerMainName: String, price: Double) {
  def getProducer: String = producerFirstName + " " + producerMainName

  def summaryLine: String = title + " ( " + producerMainName + ", " + producerFirstName + " )"
}

class CdProduct(title: String, producerFirstName: String, producerMainName: String, price: Double, val playLength: Int) extends ShopProduct(title, producerFirstName, producerMainName, price) {
  override def summaryLine: String = super.summaryLine + ": playing time - " + playLength
}

class BookProduct(title: String, producerFirstName: String, producerMainName: String, price: Double, val numberOfPages: Int) extends ShopProduct(title, producerFirstName, producerMainName, price) {
  override def summaryLine: String = super.summaryLine + ": page count - " + numberOfPages
}