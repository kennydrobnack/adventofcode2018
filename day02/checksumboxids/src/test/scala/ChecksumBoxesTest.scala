class ChecksumBoxesTest extends org.scalatest.FunSuite {
  test("letterOccursNumberOfTimesOnLabel correctly returns false if letter does not occur N times") {
    assert(ChecksumBoxes.letterOccursNumberOfTimesOnLabel("a", 2) === false)
  }

  test("letterOccursNumberOfTimesOnLabel correctly returns true if letter does occur N times") {
    assert(ChecksumBoxes.letterOccursNumberOfTimesOnLabel("aabcdeef", 2), true)
  }

  test("ChecksumBoxes.calculateChecksum gets correct checksum with empty list") {
    assert(ChecksumBoxes.calculateChecksum(List()) === 0)
  }
  test("ChecksumBoxes.calculateChecksum gets correct checksum with one item") {
    assert(ChecksumBoxes.calculateChecksum(List("aabbbccddde")) === 1)
  }
}
