import scala.io.Source

object Overlap extends App {
  def readFromFile(fileName: String): List[String] = {
    Source.fromFile(fileName).getLines.toList
  }
}