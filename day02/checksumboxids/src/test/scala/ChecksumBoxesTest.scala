class ChecksumBoxesTest extends org.scalatest.FunSuite {
  test("ChecksumBoxes.checksum") {
    assert(ChecksumBoxes.checksum(List()) === 0)
  }
}
