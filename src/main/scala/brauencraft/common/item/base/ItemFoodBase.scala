package brauencraft.common.item.base

import brauencraft.Brauencraft
import net.minecraft.item.ItemFood

abstract class ItemFoodBase(
  val amount: Int,
  val saturation: Float,
  val isWolfFood: Boolean = false
) extends ItemFood(amount, saturation, isWolfFood) {
  setRegistryName(Brauencraft.MOD_ID, getClass.getSimpleName.toLowerCase)
  setTranslationKey(getClass.getSimpleName.toLowerCase)
}
