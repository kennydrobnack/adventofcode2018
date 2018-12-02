object ChecksumBoxes extends App {
  def calculateChecksum(boxLabels: List[String]): Int = {
    val boxesWithTwoLettersRepeating = boxLabels.filter(b => letterOccursNumberOfTimesOnLabel(b, 2)).length
    val boxesWithThreeLettersRepeating = boxLabels.filter(b => letterOccursNumberOfTimesOnLabel(b, 3)).length
    boxesWithTwoLettersRepeating * boxesWithThreeLettersRepeating 
  }

  def letterOccursNumberOfTimesOnLabel(boxLabel: String, times: Int): Boolean ={
    boxLabel.groupBy(c => c.toLower).map(e => (e._2.length, e._1)).contains(times)
  }
}