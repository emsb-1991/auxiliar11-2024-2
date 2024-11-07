package world

import tool.Tool
import world.Chunk

class Player {
  def mine(tool: Tool, chunk: Chunk): Unit = {
    chunk.getMinedWithVisitor(tool)
    // chunk.getMined(tool)
    
  }
}
