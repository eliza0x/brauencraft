package brauencraft.common.block.base

import brauencraft.Brauencraft
import brauencraft.common.util.BaseUtil
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material

abstract class BlockContainerBase extends BlockContainer(Material.SAND) with BaseUtil {
  setRegistryName(Brauencraft.MOD_ID, getClassName)
  setTranslationKey(getClassName)
  setHardness(0.5F)
  setResistance(0.5F)
}
