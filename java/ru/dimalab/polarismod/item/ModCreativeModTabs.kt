package ru.dimalab.polarismod.item

import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.RegistryObject
import ru.dimalab.polarismod.PolarisMod
import ru.dimalab.polarismod.block.ModBlocks

object ModCreativeModTabs {

    val CREATIVE_MODE_TABS: DeferredRegister<CreativeModeTab> =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PolarisMod.MODID)

    val POLARIS_TAB: RegistryObject<CreativeModeTab> =
        CREATIVE_MODE_TABS.register("polaris_tab") {
            CreativeModeTab.builder()
                .icon { ItemStack(ModItems.SAPPHIRE.get()) }
                .title(Component.translatable("creativetab.polaris_tab"))
                .displayItems { _, output ->

                    output.accept(ModItems.SAPPHIRE.get())
                    output.accept(ModItems.RAW_SAPPHIRE.get())

                    output.accept(ModItems.METAL_DETECTOR.get())

                    output.accept(ModItems.STRAWBERRY.get())
                    output.accept(ModItems.PINE_CONE.get())

                    output.accept(ModBlocks.SAPPHIRE_BLOCK.get())
                    output.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get())

                    output.accept(ModBlocks.SAPPHIRE_ORE.get())
                    output.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get())
                    output.accept(ModBlocks.NETHER_SAPPHIRE_ORE.get())
                    output.accept(ModBlocks.END_STONE_SAPPHIRE_ORE.get())

                    output.accept(ModBlocks.SOUND_BLOCK.get())
                }
                .build()
        }

    fun register(eventBus: IEventBus) {
        CREATIVE_MODE_TABS.register(eventBus)
    }
}
