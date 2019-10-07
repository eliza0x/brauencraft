package brauencraft.common.block

import brauencraft.common.block.base.BlockContainerBase
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

object BarrelOpened extends BlockContainerBase {
  override def createNewTileEntity(worldIn: World, meta: Int): TileEntity = ???
}
