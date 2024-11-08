package block

import tool._
import world.Chunk

class Wood extends ABlock("Wood") {
  override def accept(visitor: Tool, c: Chunk): Unit = {
    visitor.visitWood(this, c)
  }

  override def use(visitor: Tool, c: Chunk): Unit = {
    visitor match
      case a: Axe => a.visitWood(this, c)
      case b: Shovel => b.visitWood(this, c)
      case _ => println("not implemented")
  }
}
