class PolymersTest extends org.scalatest.FunSuite {
  test("Polymers.condense returns given string if no further condensation can be done") {
    assert(Polymers.condense("dabCBAcaDA") === "dabCBAcaDA")
  }

  test("Polymers.condense removes any adjacent matching upper & lowercase letters") {
    assert(Polymers.condense("dabAcCaCBAcCcaDA") === "dabCBAcaDA")
  }

  test("Polymers.readFromFile reads in polymers from a file") {
      assert(Polymers.readFromFile("test.txt") === List("dabCBAcaDA", "dabAcCaCBAcCcaDA"))
  }

  test("Polymers.getUniqueList gets a list of unique polymers") {
    assert(Polymers.getUniqueList("dabAcCaCBAcCcaDA") === List('a', 'b', 'c', 'd'))
  }
}
