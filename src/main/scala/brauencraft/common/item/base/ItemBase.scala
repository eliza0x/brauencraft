package brauencraft.common.item.base

import brauencraft.Brauencraft
import brauencraft.common.util.BaseUtil
import net.minecraft.item.Item

abstract class ItemBase extends Item with BaseUtil {
  setRegistryName(Brauencraft.MOD_ID, getClass.getSimpleName.toLowerCase)
  setTranslationKey(getClassName)
}
