import scala.io.Source

object Overlap extends App {
  def readFromFile(fileName: String): List[String] = {
    Source.fromFile(fileName).getLines.toList
  }

  def parseClaim(claimString: String) : Map[String, List[Int]] = {
    val pattern = "#([0-9]+) @ ([0-9]+),([0-9]+): ([0-9]+)x([0-9]+)".r
    val pattern(claimId, margin_left, margin_top, width, height) = claimString
    Map("claimId" -> List(claimId.toInt), "margins" -> List(margin_left.toInt, margin_top.toInt), "size" ->  List(width.toInt, height.toInt))
  }
}