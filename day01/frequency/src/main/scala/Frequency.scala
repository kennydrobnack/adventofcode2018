import scala.io.Source

object Frequency extends App {
  val filename = args(0)
  println("Calculating frequence drift from file: " + filename)
  println(calc(readNumbersFromFile(filename)))

  def calc (numbers : List[Int]): Int = {
    numbers.sum
  }
  
  def readNumbersFromFile(fileName: String): List[Int] = {
    val lines = Source.fromFile(fileName).getLines.toList
    lines.map(_.toString.toInt)
  }
}