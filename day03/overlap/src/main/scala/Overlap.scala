import scala.io.Source

object Overlap extends App {
  val filename = args(0)
  println("Calculating overlapping fabric cuts from file: " + filename)
  val claims = readFromFile(filename)
  println("Running...")
  val numberOfOverlappingCuts = countOverlaps(claims)
  println("Total number of overlapping cuts: " + numberOfOverlappingCuts)
//  println("Calculating which cuts have no overlaps... ")
//  val noOverlaps = findNoOverLap(claims)
//  println("The following claim has no overlaps: " + noOverlaps)

  def readFromFile(fileName: String): List[String] = {
    Source.fromFile(fileName).getLines.toList
  }

  def parseClaim(claimString: String) : Map[String, List[Int]] = {
    val pattern = "#([0-9]+) @ ([0-9]+),([0-9]+): ([0-9]+)x([0-9]+)".r
    val pattern(claimId, margin_left, margin_top, width, height) = claimString
    Map("claimId" -> List(claimId.toInt), "margins" -> List(margin_left.toInt, margin_top.toInt), "size" ->  List(width.toInt, height.toInt))
  }

  def cutFabric(claimString: String): Map[List[Int], String] = {
    val claim = parseClaim(claimString)
    val claimNumber = claim("claimId").head.toString
    val firstRow = claim("margins").last + 1
    val lastRow = claim("size").last + firstRow - 1
    val firstColumn = claim("margins").head + 1
    val lastColumn = firstColumn + claim("size").head - 1
    var fabricSquaresToCut = Map[List[Int], String]()
    for (rowNumber <- firstRow to lastRow) {
      fabricSquaresToCut = fabricSquaresToCut ++ createRow(firstColumn, lastColumn, rowNumber, claimNumber)
    }
    fabricSquaresToCut
  }

  def createRow(firstColumn: Int, lastColumn: Int, rowNumber : Int, claimNumber: String) :Map[List[Int], String] = {
    (firstColumn to lastColumn).map{ e => List(e, rowNumber) -> claimNumber }.toMap
  }

  def countOverlaps(claims: List[String]) : Int = {
    val fabricCuts = claims.map( cut => cutFabric(cut))
    var allCuts = List[List[Int]]()
    for ( c <- fabricCuts ) {
      allCuts ++= c.keys
    }
    allCuts.groupBy(identity).mapValues(_.size).filter{e => e._2 > 1}.size
  }

  def findNoOverLap(cuts : Map[List[Int], String], claimToCheck: Map[List[Int], String]) : Boolean = {
    val fabricCuts = claims.map( cut => cutFabric(cut))
    for (c <- fabricCuts) {
      if (c.keys.intersect(claimToCheck.keys).size > 0) {
        return false
      }
    }
    true
  }

}