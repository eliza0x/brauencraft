package brauencraft.common.register

import net.minecraft.block.{ Block => MCBlock }
import net.minecraftforge.event.RegistryEvent

import brauencraft.common.block

object Block {
  def register(event: RegistryEvent.Register[MCBlock]): Unit = {
    event.getRegistry.registerAll(
      block.Barrel,
      block.Mill
    )
  }
}
