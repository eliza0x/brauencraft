package brauencraft.client

import brauencraft.Brauencraft
import brauencraft.common.{Proxy => CommonProxy}
import net.minecraft.block.Block
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraft.util.ResourceLocation

// ここをobjectにすると起動しなくなる、つらい
class Proxy extends CommonProxy
