class OverlapTest extends org.scalatest.FunSuite {
  test("Overlap.readFromFile reads in claims from a file") {
    assert(Overlap.readFromFile("test.txt") === List("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2"))
  }
}
