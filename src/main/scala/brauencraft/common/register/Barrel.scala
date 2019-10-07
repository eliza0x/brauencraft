package brauencraft.common.register

import brauencraft.common.barrel._
import brauencraft.common.item
import net.minecraft.item.Item

import scala.collection.SortedSet

object Barrel {
  def register(): Unit = {
    RecipeBook.register(whisky)
  }
  val whisky = Recipe(
    result = List(item.Whisky),
    requiredTick = 24000, //1day
    materials = SortedSet(RecipeMaterial(item.NewMakeSpirits, CloseRange(1,1)))
  )
}

