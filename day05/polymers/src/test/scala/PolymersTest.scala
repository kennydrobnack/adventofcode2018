class PolymersTest extends org.scalatest.FunSuite {
  test("Polymers.condense returns given string if no further condensation can be done") {
    assert(Polymers.condense("dabCBAcaDA") === "dabCBAcaDA")
  }

  test("Polymer.condense removes any adjacent matching upper & lowercase letters") {
    assert(Polymers.condense("dabAcCaCBAcCcaDA") === "dabCBAcaDA")
  }
}
