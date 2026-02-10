package ru.dimalab.polarismod.block

import net.minecraft.util.valueproviders.UniformInt
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.DropExperienceBlock
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import ru.dimalab.polarismod.PolarisMod
import ru.dimalab.polarismod.block.custom.SoundBlock
import ru.dimalab.polarismod.item.ModItems
import java.util.function.Supplier

object ModBlocks {

    @JvmField
    val BLOCKS: DeferredRegister<Block> =
        DeferredRegister.create(ForgeRegistries.BLOCKS, PolarisMod.MODID)

    // Blocks
    @JvmField
    val SAPPHIRE_BLOCK: RegistryObject<Block> = registerBlock("sapphire_block") {
        Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST))
    }

    @JvmField
    val RAW_SAPPHIRE_BLOCK: RegistryObject<Block> = registerBlock("raw_sapphire_block") {
        Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST))
    }

    @JvmField
    val SAPPHIRE_ORE: RegistryObject<Block> = registerBlock("sapphire_ore") {
        DropExperienceBlock(
            BlockBehaviour.Properties.copy(Blocks.STONE)
                .strength(2f)
                .requiresCorrectToolForDrops(),
            UniformInt.of(3, 6)
        )
    }

    @JvmField
    val DEEPSLATE_SAPPHIRE_ORE: RegistryObject<Block> = registerBlock("deepslate_sapphire_ore") {
        DropExperienceBlock(
            BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                .strength(3f)
                .requiresCorrectToolForDrops(),
            UniformInt.of(3, 7)
        )
    }

    @JvmField
    val NETHER_SAPPHIRE_ORE: RegistryObject<Block> = registerBlock("nether_sapphire_ore") {
        DropExperienceBlock(
            BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                .strength(1f)
                .requiresCorrectToolForDrops(),
            UniformInt.of(3, 7)
        )
    }

    @JvmField
    val END_STONE_SAPPHIRE_ORE: RegistryObject<Block> = registerBlock("end_stone_sapphire_ore") {
        DropExperienceBlock(
            BlockBehaviour.Properties.copy(Blocks.END_STONE)
                .strength(5f)
                .requiresCorrectToolForDrops(),
            UniformInt.of(3, 7)
        )
    }

    @JvmField
    val SOUND_BLOCK: RegistryObject<Block> = registerBlock("sound_block") {
        SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK))
    }

    private fun <T : Block> registerBlock(name: String, blockSupplier: () -> T): RegistryObject<T> {
        val toReturn: RegistryObject<T> = BLOCKS.register(name, Supplier { blockSupplier() })
        registerBlockItem(name, toReturn)
        return toReturn
    }

    private fun <T : Block> registerBlockItem(name: String, block: RegistryObject<T>): RegistryObject<Item> {
        // IMPORTANT: ModItems must expose ITEMS as @JvmField val ITEMS (DeferredRegister<Item>)
        // so we can do ModItems.ITEMS.register(...)
        return ModItems.ITEMS.register(name, Supplier { BlockItem(block.get(), Item.Properties()) })
    }

    fun register(eventBus: IEventBus) {
        BLOCKS.register(eventBus)
    }
}
