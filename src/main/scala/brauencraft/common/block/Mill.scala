package brauencraft.common.block

import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.util.math.BlockPos
import net.minecraft.util.{EnumFacing, EnumHand}
import brauencraft.common.block.base.BlockBase
import brauencraft.common.item

object Mill extends BlockBase {
  override def onBlockActivated(worldIn: World, pos: BlockPos, state: IBlockState, playerIn: EntityPlayer, hand: EnumHand, facing: EnumFacing, hitX: Float, hitY: Float, hitZ: Float): Boolean = {
    val heldItemMaybe: Option[Item] = Option(playerIn.getHeldItem(EnumHand.MAIN_HAND).getItem)
    for (heldItem <- heldItemMaybe; if heldItem == item.CoffeeBean) {
      declPlayerHeldItem(playerIn)
      playerIn.inventory.add(1, new ItemStack(item.CoffeePowder))
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
