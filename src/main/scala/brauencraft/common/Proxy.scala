package brauencraft.common

import net.minecraft.item.Item
import net.minecraftforge.event.RegistryEvent
import register.{ Item => RegisterItem }

trait Proxy {
  def registerItem(event: RegistryEvent.Register[Item]): Unit = RegisterItem.register(event)
}