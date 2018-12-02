import scala.io.Source

object Frequency extends App {
  val filename = args(0)
  println("Calculating final frequency from file: " + filename)
  val numbers = readNumbersFromFile(filename)
  println(calcFinalFrequency(numbers))
  println("Calculating first frequency seen twice: ")
  println(findDuplicate(numbers))

  def calcFinalFrequency (numbers : List[Int]): Int = {
    numbers.sum
  }

  def findDuplicate(numbers : List[Int]): Int = {
    var currentValue = 0
    var seenNumbers = Map[Int, Int]()
    seenNumbers = seenNumbers + (0 -> 1)
    var latestSeen = 0
    while (seenNumbers.get(latestSeen) != 2) {
      for (number <- numbers) {
        latestSeen = latestSeen + number
        if (seenNumbers.contains(latestSeen)) {
          return latestSeen 
        }
        else {
          seenNumbers += (latestSeen -> 1)
        }
      }
    }
    latestSeen
  }
  
  def readNumbersFromFile(fileName: String): List[Int] = {
    val lines = Source.fromFile(fileName).getLines.toList
    lines.map(_.toString.toInt)
  }
}