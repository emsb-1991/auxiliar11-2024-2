package tool

class Shovel extends ATool("Shovel") {
  override def use(b: block.Block, c: world.Chunk): Unit = {
    b match {
      case d: block.Dirt => {
        addBlock(d)
        c.removeBlock(d)
      }
      case w: block.Wood =>
        c.removeBlock(w)
      case _ => ()
    }
  }

  override def visitDirt(b: block.Dirt, c: world.Chunk): Unit = {
    addBlock(b)
    c.removeBlock(b)
  }

  override def visitWood(b: block.Wood, c: world.Chunk): Unit = {
    c.removeBlock(b)
  }

}
