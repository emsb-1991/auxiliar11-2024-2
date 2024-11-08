package block

import tool._
import world.Chunk

class Dirt extends ABlock("Dirt") {
  override def accept(visitor: Tool, c: Chunk): Unit = {
    visitor.visitDirt(this, c)
  }

  override def use(visitor: Tool, c: Chunk): Unit = {
    visitor match
      case a: Pickaxe => a.visitDirt(this, c)
      case b: Shovel => b.visitDirt(this, c)
      case _ => println("not implemented")
  }
}
