package brauencraft.common.register

import brauencraft.Brauencraft
import brauencraft.common.tileentity
import net.minecraft.block.{ Block => MCBlock }
import net.minecraft.util.ResourceLocation
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.registry.GameRegistry

object TileEntity {
  def register(): Unit = {
      GameRegistry.registerTileEntity(classOf[tileentity.Barrel], new ResourceLocation(Brauencraft.MOD_ID+"_tile"))
  }
}
