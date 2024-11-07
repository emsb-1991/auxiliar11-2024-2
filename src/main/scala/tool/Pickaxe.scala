package tool

class Pickaxe extends ATool("Pickaxe") {
  override def use(b: block.Block, c: world.Chunk): Unit = {
    b match
      case s: block.Stone => {
        addBlock(s)
        c.removeBlock(s)
      }
      case d: block.Dirt =>
        c.removeBlock(d)

      case _ => ()
  }

  override def visitStone(b: block.Stone, c: world.Chunk): Unit = {
    addBlock(b)
    c.removeBlock(b)
  }

  override def visitDirt(b: block.Dirt, c: world.Chunk): Unit = {
    c.removeBlock(b)
  }
}
