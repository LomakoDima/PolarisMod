package ru.dimalab.polarismod

import com.mojang.logging.LogUtils
import net.minecraft.world.item.CreativeModeTabs
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent
import net.minecraftforge.event.server.ServerStartingEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import org.slf4j.Logger
import ru.dimalab.polarismod.block.ModBlocks
import ru.dimalab.polarismod.item.ModCreativeModTabs
import ru.dimalab.polarismod.item.ModItems

@Mod(PolarisMod.MODID)
class PolarisMod {

    init {
        val modEventBus = FMLJavaModLoadingContext.get().modEventBus

        ModCreativeModTabs.register(modEventBus)

        ModItems.ITEMS.register(modEventBus)
        ModBlocks.register(modEventBus)

        MinecraftForge.EVENT_BUS.register(this)
        modEventBus.addListener(::addCreative)
    }

    private fun addCreative(event: BuildCreativeModeTabContentsEvent) {
        if (event.tabKey == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.SAPPHIRE)
            event.accept(ModItems.RAW_SAPPHIRE)
        }
    }

    @SubscribeEvent
    fun onServerStarting(event: ServerStartingEvent) {
        // your logic here (empty like in Java)
    }

    companion object {
        const val MODID: String = "polarismod"
        val LOGGER: Logger = LogUtils.getLogger()
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = [Dist.CLIENT])
    object ClientModEvents {
        @SubscribeEvent
        @JvmStatic
        fun onClientSetup(event: FMLClientSetupEvent) {
            // your logic here (empty like in Java)
        }
    }
}
