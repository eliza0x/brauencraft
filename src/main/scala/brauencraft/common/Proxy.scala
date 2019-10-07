package brauencraft.common

import brauencraft.Brauencraft
import net.minecraft.block.Block
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.util.ResourceLocation
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.registry.GameRegistry
import register.{Item => RegisterItem}
import register.{Block => RegisterBlock}
import register.{TileEntity => RegisterTileEntity}
import register.{Barrel => RegisterBarrel}

trait Proxy {
  RegisterBarrel.register()
  def registerItem(event: RegistryEvent.Register[Item]): Unit = RegisterItem.register(event)
  def registerBlock(event: RegistryEvent.Register[Block]): Unit = RegisterBlock.register(event)
  // Forge 1.14時点でTileEntitiy用のイベントが用意されていないためBlockEventのタイミングで行うようにドキュメントに書かれている
  def registerTileEntitiy(event: RegistryEvent.Register[Block]): Unit = RegisterTileEntity.register()
}