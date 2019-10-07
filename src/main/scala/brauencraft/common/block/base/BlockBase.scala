package brauencraft.common.block.base

import brauencraft.Brauencraft
import net.minecraft.block.Block
import net.minecraft.block.material.Material

abstract class BlockBase extends Block(Material.SAND) {
  setRegistryName(Brauencraft.MOD_ID, getClass.getSimpleName.toLowerCase())
  setTranslationKey(getClass.getSimpleName.toLowerCase())
  setHardness(0.5F)
  setResistance(0.5F)
}
