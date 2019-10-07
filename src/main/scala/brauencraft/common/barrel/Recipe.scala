package brauencraft.common.barrel

import net.minecraft.item.{Item, ItemStack}
import net.minecraft.world.biome.Biome

import scala.collection.SortedSet

case class CloseRange(s: Int, e: Int) {
  def contains(n: Int): Boolean = s <= n && n <= e
}

case class Material(item: Item, count: Int) extends Ordered[Material] {
  override def compare(that: Material): Int = {
    this.item.getTranslationKey.compareTo(that.item.getTranslationKey)
  }
}

case class RecipeMaterial(item: Item, range: CloseRange) extends Ordered[RecipeMaterial] {
  override def compare(that: RecipeMaterial): Int = {
    this.item.getTranslationKey.compareTo(that.item.getTranslationKey)
  }
}

case class Recipe(
  materials: SortedSet[RecipeMaterial],
  result: List[Item],
  requiredTick: Int,
  supportedBiome: Option[List[Biome]] = None,
  barrelMaterial: Option[Item] = None
  ) {
  // O((materials.size, ms.size).size)
  def matchOf(ms: SortedSet[Material]): Boolean = {
    val sameItems = materials.zip(ms).forall { case (m1, m2) =>
      return m1.item == m2.item && m1.range.contains(m2.count)
    }
    materials.size == ms.size && sameItems
  }
}
