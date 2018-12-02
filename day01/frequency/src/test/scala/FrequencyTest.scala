class FrequencyTest extends org.scalatest.FunSuite {
  test("Frequency.calc returns 0 with empty list") {
    assert(Frequency.calc(List()) === 0)
  }
}
