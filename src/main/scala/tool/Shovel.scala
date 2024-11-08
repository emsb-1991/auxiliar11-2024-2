package tool

class Shovel extends ATool("Shovel"){
  override def visitWood(b: block.Wood, c: world.Chunk): Unit = {
      c.removeBlock(b)
  }

  override def visitDirt(b: block.Dirt, c: world.Chunk): Unit = {
    addBlock(b)
    c.removeBlock(b)
  }
}
