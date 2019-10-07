package brauencraft.common.register

import net.minecraft.item.{ Item => MCItem }
import net.minecraftforge.event.RegistryEvent
import brauencraft.common.item

object Item {
  def register(event: RegistryEvent.Register[MCItem]): Unit = {
    event.getRegistry.registerAll(
      item.Barrel,
      item.CoffeeBean,
      item.CoffeePowder,
      item.Mill,
      item.NewMakeSpirits,
      item.Whisky
    )
  }
}
