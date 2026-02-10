package ru.dimalab.polarismod.item

import net.minecraft.world.item.Item
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import ru.dimalab.polarismod.PolarisMod
import ru.dimalab.polarismod.item.custom.FuelItem
import ru.dimalab.polarismod.item.custom.MetalDetectorItem

object ModItems {

    val ITEMS: DeferredRegister<Item> =
        DeferredRegister.create(ForgeRegistries.ITEMS, PolarisMod.MODID)

    val SAPPHIRE: RegistryObject<Item> =
        ITEMS.register("sapphire") {
            Item(Item.Properties())
        }

    val RAW_SAPPHIRE: RegistryObject<Item> =
        ITEMS.register("raw_sapphire") {
            Item(Item.Properties())
        }

    val METAL_DETECTOR: RegistryObject<Item> =
        ITEMS.register("metal_detector") {
            MetalDetectorItem(Item.Properties().durability(100))
        }

    @JvmField
    val STRAWBERRY: RegistryObject<Item> =
        ITEMS.register("strawberry") {
            Item(
                Item.Properties().food(ModFoods.STRAWBERRY)
            )
        }

    @JvmField
    val PINE_CONE: RegistryObject<Item> =
        ITEMS.register("pine_cone") {
            FuelItem(Item.Properties(), 400)
        }


    fun register(eventBus: IEventBus) {
        ITEMS.register(eventBus)
    }
}
