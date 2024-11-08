package block

import tool._
import world.Chunk

class Stone extends ABlock("Stone") {
  override def accept(visitor: Tool, c: Chunk): Unit = {
    visitor.visitStone(this, c)
  }

  override def use(visitor: Tool, c: Chunk): Unit = {
    visitor match
      case a: Axe => a.visitStone(this, c)
      case b: Pickaxe => b.visitStone(this, c)
      case _ => println("not implemented")
  }
}
