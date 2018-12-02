class FrequencyTest extends org.scalatest.FunSuite {
  test("Frequency.calc returns 0 with empty list") {
    assert(Frequency.calc(List()) === 0)
  }
  test("Frequency.calc returns the number with a single number list") {
    assert(Frequency.calc(List(42)) === 42)
  }
  test("Frequency.calc returns single negative number if we have a negative number") {
    assert(Frequency.calc(List(-42)) === -42)
  }
  test("Frequency.calc returns the numbers summed up") {
    assert(Frequency.calc(List(0, 1, 2, 3, -6, -42)) === -42)
  }
}
