import munit.FunSuite

class ToolTest extends FunSuite {
  var axe: tool.Axe = _
  var pickaxe: tool.Pickaxe = _
  var shovel: tool.Shovel = _
  var chunk: world.Chunk = _

  override def beforeEach(context: BeforeEach): Unit = {
    axe = new tool.Axe()
    pickaxe = new tool.Pickaxe()
    shovel = new tool.Shovel()
    chunk = new world.Chunk()
  }

  test("Axe is a tool") {
    assert(axe.isInstanceOf[tool.ATool])
    assertEquals(axe.name, "Axe")
  }

  test("Pickaxe is a tool") {
    assert(pickaxe.isInstanceOf[tool.ATool])
    assertEquals(pickaxe.name, "Pickaxe")
  }

  test("Shovel is a tool") {
    assert(shovel.isInstanceOf[tool.ATool])
    assertEquals(shovel.name, "Shovel")
  }

  test("Axe can remove wood and stone but only store wood") {
    val wood = new block.Wood()
    val stone = new block.Stone()
    chunk.addBlock(wood)
    chunk.addBlock(stone)
    chunk.getMinedWithVisitor(axe)
    assert(axe.obtainBlocks().contains(wood))
    assert(!axe.obtainBlocks().contains(stone))
  }

  test("Axe can't break dirt") {
    val dirt = new block.Dirt()
    chunk.addBlock(dirt)
    chunk.getMinedWithMatch(axe)
    assert(!axe.obtainBlocks().contains(dirt))
  }

  test("Pickaxe can remove stone and dirt but only store stone") {
    val stone = new block.Stone()
    val dirt = new block.Dirt()
    chunk.addBlock(stone)
    chunk.addBlock(dirt)
    chunk.getMinedWithVisitor(pickaxe)
    assert(pickaxe.obtainBlocks().contains(stone))
    assert(!pickaxe.obtainBlocks().contains(dirt))
  }

  test("Pickaxe can't break wood") {
    val wood = new block.Wood()
    chunk.addBlock(wood)
    chunk.getMinedWithMatch(pickaxe)
    assert(!pickaxe.obtainBlocks().contains(wood))
  }

  test("Shovel can remove dirt and wood but only store dirt") {
    val dirt = new block.Dirt()
    val wood = new block.Wood()
    chunk.addBlock(dirt)
    chunk.addBlock(wood)
    chunk.getMinedWithVisitor(shovel)
    assert(shovel.obtainBlocks().contains(dirt))
    assert(!shovel.obtainBlocks().contains(wood))
  }

  test("Shovel can't break stone") {
    val stone = new block.Stone()
    chunk.addBlock(stone)
    chunk.getMinedWithMatch(shovel)
    assert(!shovel.obtainBlocks().contains(stone))
  }
}
