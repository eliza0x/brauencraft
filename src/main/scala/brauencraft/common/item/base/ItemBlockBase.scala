package brauencraft.common.item.base

import brauencraft.Brauencraft
import brauencraft.common.util.BaseUtil
import net.minecraft.block.Block
import net.minecraft.item.ItemBlock

abstract class ItemBlockBase(block: Block) extends ItemBlock(block) with BaseUtil {
  setRegistryName(Brauencraft.MOD_ID, getClassName)
  setTranslationKey(getClassName)
}
