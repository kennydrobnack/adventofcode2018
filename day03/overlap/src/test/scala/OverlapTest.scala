class OverlapTest extends org.scalatest.FunSuite {
  test("Overlap.readFromFile reads in claims from a file") {
    assert(Overlap.readFromFile("test.txt") === List("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2"))
  }

  test("Parse claim gets claim id, margin and size") {
    assert(Overlap.parseClaim("#1 @ 1,3: 4x4") === Map("claimId" -> List(1), "margins" -> List(1, 3), "size" -> List(4, 4)))
  }

  test("It figures out which pieces of fabric will be cut") {
    assert(Overlap.cutFabric("#1 @ 1,3: 4x4") === Map(
      List(2,4) -> "1",
      List(2,5) -> "1",
      List(2,6) -> "1",
      List(2,7) -> "1",
      List(3,4) -> "1",
      List(3,5) -> "1",
      List(3,6) -> "1",
      List(3,7) -> "1",
      List(4,4) -> "1",
      List(4,5) -> "1",
      List(4,6) -> "1",
      List(4,7) -> "1",
      List(5,4) -> "1",
      List(5,5) -> "1",
      List(5,6) -> "1",
      List(5,7) -> "1"
    ))
  }

  test("It counts how many cuts overlap") {
    assert(Overlap.countOverlaps(List("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2")) === 4)
  }

  test("It figures which claim has zero overlaps") {
    assert(Overlap.findNoOverLap(List("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2")) === 3)
  }
}
