class FrequencyTest extends org.scalatest.FunSuite {
  test("Frequency.findDuplicate returns first dup when it only flips away from zero and back") {
    assert(Frequency.findDuplicate(List(1, -1)) == 0)
  }
  test("Frequency.findDuplicate returns first dup when going through the list once") {
    assert(Frequency.findDuplicate(List(2, -4, 4)) == 2)
  }
  test("Frequency.calcFinalFrequency returns 0 with empty list") {
    assert(Frequency.calcFinalFrequency(List()) === 0)
  }
  test("Frequency.calcFinalFrequency returns the number with a single number list") {
    assert(Frequency.calcFinalFrequency(List(42)) === 42)
  }
  test("Frequency.calcFinalFrequency returns single negative number if we have a negative number") {
    assert(Frequency.calcFinalFrequency(List(-42)) === -42)
  }
  test("Frequency.calcFinalFrequency returns the numbers summed up") {
    assert(Frequency.calcFinalFrequency(List(0, 1, 2, 3, -6, -42)) === -42)
  }
  test("Frequency.calcFinalFrequency can read a file and turn a list of numbers one per line into a list of Ints") {
      assert(Frequency.readNumbersFromFile("test.txt") === List(0, 1, 2, 3, -42))
  }
}
