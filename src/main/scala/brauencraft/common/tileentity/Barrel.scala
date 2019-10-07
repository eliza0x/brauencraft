package brauencraft.common.tileentity

import net.minecraft.item.Item
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.network.NetworkManager
import net.minecraft.network.play.server.SPacketUpdateTileEntity
import net.minecraft.tileentity.TileEntity

import scala.collection.SortedSet
import scala.collection.mutable.{Map => MutableMap}
import brauencraft.common.barrel.{Material, Recipe, RecipeBook}
import brauencraft.common.item
import net.minecraft.util.ITickable

class Barrel extends TileEntity with ITickable {
  val container = new BarrelContainer

  override def update(): Unit = container.tick()
  override def writeToNBT(compound: NBTTagCompound): NBTTagCompound = super.writeToNBT(compound)
  override def readFromNBT(compound: NBTTagCompound): Unit = super.readFromNBT(compound)
  override def getUpdatePacket: SPacketUpdateTileEntity = super.getUpdatePacket
  override def onDataPacket(net: NetworkManager, pkt: SPacketUpdateTileEntity): Unit = super.onDataPacket(net, pkt)
}

class BarrelContainer() {
  private val materials: MutableMap[Item, Int] = MutableMap()
  private var currentRecipe: Option[Recipe] = None
  private var recentUpdateFrom: Int = 0
  val maxSolidItemSize: Int = 32
  val maxLiquidItemSize: Int = 1

  def getCurrentRecipe: Option[Recipe] = currentRecipe

  def tick(): Unit = {
    recentUpdateFrom += 1
    for (r <- currentRecipe; if r.requiredTick <= recentUpdateFrom) {
      recentUpdateFrom = 0
      materials.clear()
      for (elem <- r.result) {materials(elem) = 0}
      updateCurrentRecipe()
    }
  }

  def insert(item: Item): Unit = {
    if (materials.contains(item)) {
      materials(item) = materials(item) + 1
    } else {
      materials(item) = 1
    }
    updateCurrentRecipe()
  }

  def canInsertOf(item: Item): Boolean = {
    if (insertableLiquidItems.contains(item)) {
      materials
        .filter(insertableLiquidItems.contains(_))
        .map { case (_, cnt) => cnt }
        .sum < maxLiquidItemSize
    } else if(insertableSolidItems.contains(item)) {
      materials
        .filter(insertableSolidItems.contains(_))
        .map { case (_, cnt) => cnt }
        .sum < maxSolidItemSize
    } else {
      false
    }
  }

  private def updateCurrentRecipe(): Unit = {
    val ms: Set[Material] =  materials.map(m => Material(m._1, m._2)).toSet
    currentRecipe = RecipeBook.searchMatched(SortedSet[Material]()++ms)
  }

  private val insertableLiquidItems: List[Item] = List(
    Item.getByNameOrId("minecraft:water_bucket"),
    item.NewMakeSpirits,
    item.Whisky
  )

  private val insertableSolidItems: List[Item] = List(
    Item.getByNameOrId("minecraft:wheat")
  )
}

