package brauencraft.common.barrel

import scala.collection.SortedSet
import scala.collection.mutable.MutableList

object RecipeBook {
  private var registeredRecipes = MutableList[Recipe]()

  def register(recipe: Recipe): Unit = {
    registeredRecipes += recipe
  }

  def searchMatched(materials: SortedSet[Material]): Option[Recipe] = {
    registeredRecipes.find(_.matchOf(materials))
  }
}
