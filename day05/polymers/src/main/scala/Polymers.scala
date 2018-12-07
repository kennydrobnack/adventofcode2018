object Polymers extends App {
  def condense(polymers: String) : String = {
    var currentString = polymers
    var droppedCharacters = true
    while (droppedCharacters == true) {
      val updatedString = dropMatchingCharacters(currentString)
      if (updatedString != currentString) {
        droppedCharacters = true
        currentString = updatedString
      }
      else {
        droppedCharacters = false
      }
    }
    currentString
  }

  def dropMatchingCharacters(updateString: String): String = {
    var charArray = updateString.toArray
    var i = 0
    for (i <- 0 to charArray.length - 2) {
      if (charArray.charAt(i) != charArray.charAt(i + 1) && charArray.charAt(i).toUpper == charArray.charAt(i + 1).toUpper) {
        return charArray.patch(i, Nil, 2).mkString
      }
    }
    charArray.mkString
  }
}