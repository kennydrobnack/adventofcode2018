class OverlapTest extends org.scalatest.FunSuite {
  test("Overlap.overlappingSquares returns 0 before we do anything") {
    assert(Overlap.overlappingSquares(0) === 0)
  }
}
