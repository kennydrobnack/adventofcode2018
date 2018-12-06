class PolymersTest extends org.scalatest.FunSuite {
  test("Polymers.condense") {
    assert(Polymers.condense("dabCBAcaDA") === "dabCBAcaDA")
  }
}
