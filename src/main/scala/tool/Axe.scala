package tool
import block.Block
import world.Chunk

class Axe extends ATool("Axe") {
  override def use(b: Block, c: Chunk): Unit = {
    b match {
      case w: block.Wood => {
        addBlock(w)
        c.removeBlock(w)
      }
      case d: block.Dirt =>
        c.removeBlock(d)
      case _ => ()
    }
  }

  override def visitWood(b: block.Wood, c: Chunk): Unit = {
    addBlock(b)
    c.removeBlock(b)
  }

  override def visitStone(b: block.Stone, c: Chunk): Unit = {
    c.removeBlock(b)
  }
}
