import scala.io.Source

object Polymers extends App {
  val filename = args(0)
  println("Reading polymer data from file: " + filename)
  val polymers = readFromFile(filename)
  val condensedPolymer = condense(polymers.head)
  println("Resulting polymer contains " + condensedPolymer.length + " units")

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

  def getUniqueList(polymerString: String) : List[Char] = {
    polymerString.toList.map(letter => letter.toLower).distinct.sorted
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

  def readFromFile(fileName: String): List[String] = {
    Source.fromFile(fileName).getLines.toList
  }
}