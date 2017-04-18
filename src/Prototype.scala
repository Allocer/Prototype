class Message(content: String, title: String) {
  override def clone = super.clone

  override def toString = title + ": " + content
}

class ClonableProduct {
  override def clone = super.clone
}

class ProductPrototype(name: String, price: Double) extends ClonableProduct {

  def showName(): Unit = {
    println(name)
  }

  def showPrice(): Unit = {
    println(price)
  }

  def showProduct(): Unit = {
    println(name + " " + price)
  }
}

class Factory {
  private def prototypes: Map[String, ProductPrototype] = Map();

  def fillPrototypes(): Unit = {
    prototypes += ("Product 1" -> new ProductPrototype("Product 1", 20.0))
    prototypes += ("Product 2" -> new ProductPrototype("Product 2", 16.5))
    prototypes += ("Product 3" -> new ProductPrototype("Product 3", 9.0))
  }

  def getPrototype(product: String): AnyRef = {
    return prototypes.get(product).get
  }
}


object Main {
  def main(args: Array[String]) = {

    val str1 = "Cos"
    val str2 = "Product 1"
    val str3 = "Product 3"

    val factory = new Factory()
    factory.fillPrototypes()

    val value1 = factory.getPrototype(str1)
    if (value1 == null) {
      println("Nie ma takiego produktu w sklepie")
    }

    val prototype1: ProductPrototype = factory.getPrototype(str2)[ProductPrototype]

    if (prototype1 == null) {
      println("Nie ma takiego produktu w sklepie")
    }
    else {
      println("Jestem: " + prototype1.showName() + "kosztuje: " + prototype1.showPrice())
    }

    val prototype2: ProductPrototype = factory.getPrototype(str3)[ProductPrototype]
    if (prototype2 == null) {
      println("Nie ma takiego produktu w sklepie")
    }
    else {
      println("Jestem: " + prototype2.showName() + "kosztuje: " + prototype2.showPrice())
    }
  }
}