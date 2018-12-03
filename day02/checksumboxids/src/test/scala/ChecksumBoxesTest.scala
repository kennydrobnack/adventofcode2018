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

  test("ChecksumBoxes.readLablesFromFile can read a file and turn a list of box label strings") {
      assert(ChecksumBoxes.readLablesFromFile("test.txt") === List("abcd", "aabbb"))
  }

  test("ChecksumBoxes.matchingLetters returns matching letters between two labels if only one mismatch") {
    assert(ChecksumBoxes.matchingLetters("abcdef", "abcdff") === "abcdf")
  }

  test("ChecksumBoxes.matchingLetters returns empty string if more than one letter mismatched") {
    assert(ChecksumBoxes.matchingLetters("abcdef", "zzcdef") === "")
  }

  test("ChecksumBoxes.findCloseMatch returns two labels that are only one letter off") {
    assert(ChecksumBoxes.findCloseMatch(List("abcde","fghij","klmno","pqrst","fguij","axcye","wvxyz")) === "fgij")
  }
}
