import block.{Dirt, Stone, Wood}
import munit.FunSuite

class BlockTest extends FunSuite {
  var d: block.Dirt = _
  var s: block.Stone = _
  var w: block.Wood = _

  override def beforeEach(context: BeforeEach): Unit = {
    d = new Dirt()
    s = new Stone()
    w = new Wood()
  }

  test("Dirt is a block") {
    assert(d.isInstanceOf[block.Block])
    assertEquals(d.name,"Dirt")
  }

  test("Stone is a block") {
    assert(s.isInstanceOf[block.Block])
    assertEquals(s.name,"Stone")
  }

  test("Wood is a block") {
    assert(w.isInstanceOf[block.Block])
    assertEquals(w.name,"Wood")
  }
}
