package brauencraft.common.item.base

import brauencraft.Brauencraft
import net.minecraft.item.Item

trait Base extends Item {
  setRegistryName(Brauencraft.MOD_ID, getClass.getName.toLowerCase)
  setTranslationKey(getClass.getName.toLowerCase)
}
