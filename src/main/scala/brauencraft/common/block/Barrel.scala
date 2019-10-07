package brauencraft.common.block

import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.util.math.BlockPos
import net.minecraft.util.{EnumFacing, EnumHand, ITickable}
import brauencraft.common.block.base.BlockContainerBase
import brauencraft.common.tileentity.{Barrel => TileBarrel}
import brauencraft.common.item

object Barrel extends BlockContainerBase {
  override def createNewTileEntity(worldIn: World, meta: Int): TileEntity = new TileBarrel

  override def onBlockActivated(worldIn: World, pos: BlockPos, state: IBlockState, playerIn: EntityPlayer, hand: EnumHand, facing: EnumFacing, hitX: Float, hitY: Float, hitZ: Float): Boolean = {
    val tileMaybe: Option[TileBarrel] = Option(worldIn.getTileEntity(pos)).map(_.asInstanceOf[TileBarrel])
    val heldItemMaybe: Option[Item] = Option(playerIn.getHeldItem(EnumHand.MAIN_HAND).getItem)
    for (tile <- tileMaybe; heldItem <- heldItemMaybe; if tile.container.canInsertOf(heldItem)) {
      tile.container.insert(heldItem)
      declPlayerHeldItem(playerIn)
      tile.markDirty()
      playerIn.inventory.markDirty()
    }
    true
  }

  private def declPlayerHeldItem(playerIn: EntityPlayer) {
    val heldItemStack: ItemStack = playerIn.getHeldItem(EnumHand.MAIN_HAND)
    heldItemStack.setCount(heldItemStack.getCount - 1)
    if (!playerIn.isCreative && heldItemStack.getCount <= 0)
      playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, ItemStack.EMPTY)
  }
}
