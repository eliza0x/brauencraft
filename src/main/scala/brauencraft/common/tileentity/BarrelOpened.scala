package brauencraft.common.tileentity

import net.minecraft.nbt.NBTTagCompound
import net.minecraft.network.NetworkManager
import net.minecraft.network.play.server.SPacketUpdateTileEntity
import net.minecraft.tileentity.TileEntity

class BarrelOpened extends TileEntity {
  override def writeToNBT(compound: NBTTagCompound): NBTTagCompound = super.writeToNBT(compound)
  override def readFromNBT(compound: NBTTagCompound): Unit = super.readFromNBT(compound)
  override def getUpdatePacket: SPacketUpdateTileEntity = super.getUpdatePacket
  override def onDataPacket(net: NetworkManager, pkt: SPacketUpdateTileEntity): Unit = super.onDataPacket(net, pkt)
}
