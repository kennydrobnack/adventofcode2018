import scala.io.Source

object ChecksumBoxes extends App {
  val filename = args(0)
  println("Calculating box label checksum from file: " + filename)
  val labels = readLablesFromFile(filename)
  println(calculateChecksum(labels))

  def calculateChecksum(boxLabels: List[String]): Int = {
    val boxesWithTwoLettersRepeating = boxLabels.filter(b => letterOccursNumberOfTimesOnLabel(b, 2)).length
    val boxesWithThreeLettersRepeating = boxLabels.filter(b => letterOccursNumberOfTimesOnLabel(b, 3)).length
    boxesWithTwoLettersRepeating * boxesWithThreeLettersRepeating 
  }

  def letterOccursNumberOfTimesOnLabel(boxLabel: String, times: Int): Boolean ={
    boxLabel.groupBy(c => c.toLower).map(e => (e._2.length, e._1)).contains(times)
  }

  def readLablesFromFile(fileName: String): List[String] = {
    Source.fromFile(fileName).getLines.toList
  }

  def matchingLetters(firstLabel: String, secondLabel: String): String = {
    var matchingLetters = "".toArray
    var mismatches = 0
    var charNum = 0
    for (c <- firstLabel) {
      if (c != secondLabel.charAt(charNum)) {
        mismatches = mismatches + 1
      }
      else {
        matchingLetters :+= c
      }
      if (mismatches > 1) {
        return ""
      }
      charNum = charNum + 1
    }
    matchingLetters.mkString
  }
}