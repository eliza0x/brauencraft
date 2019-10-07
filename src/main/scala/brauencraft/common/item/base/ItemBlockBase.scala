package brauencraft.common.item.base

import brauencraft.Brauencraft
import net.minecraft.block.Block
import net.minecraft.item.ItemBlock

abstract class ItemBlockBase(block: Block) extends ItemBlock(block) {
  setRegistryName(Brauencraft.MOD_ID, getClass.getSimpleName.toLowerCase)
  setTranslationKey(getClass.getSimpleName.toLowerCase)
}
