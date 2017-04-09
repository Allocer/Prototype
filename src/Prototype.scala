class Message(content: String, title: String) {
  override def clone = super.clone

  override def toString = title + ": " + content
}

object Main {
  def main(args: Array[String]) = {
    val firstMessage = new Message("Wiadomsoc pierwsza", "Test")
    val secondMessage = firstMessage.clone

    println(firstMessage)
    println(secondMessage)
    println(firstMessage eq secondMessage)
  }
}