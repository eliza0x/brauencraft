package brauencraft.common.item.base

import brauencraft.Brauencraft
import net.minecraft.item.Item

abstract class ItemBase extends Item {
  setRegistryName(Brauencraft.MOD_ID, getClass.getSimpleName.toLowerCase)
  setTranslationKey(getClass.getSimpleName.toLowerCase)
}
