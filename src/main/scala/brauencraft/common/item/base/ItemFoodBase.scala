package brauencraft.common.item.base

import brauencraft.Brauencraft
import brauencraft.common.util.BaseUtil
import net.minecraft.item.ItemFood

abstract class ItemFoodBase(
  val amount: Int,
  val saturation: Float,
  val isWolfFood: Boolean = false
) extends ItemFood(amount, saturation, isWolfFood) with BaseUtil {
  setRegistryName(Brauencraft.MOD_ID, getClassName)
  setTranslationKey(getClassName)
}
