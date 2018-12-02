import scala.io.Source

object Frequency extends App {
  def calc (numbers : List[Int]): Int = {
    numbers.sum
  }
  def readNumbersFromFile(fileName: String): List[Int] = {
      val lines = Source.fromFile(fileName).getLines.toList
      lines.map(_.toString.toInt)
  }
}