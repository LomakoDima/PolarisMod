package ru.dimalab.polarismod.util

import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.tags.ItemTags
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import ru.dimalab.polarismod.PolarisMod

object ModTags {

    object Blocks {

        val METAL_DETECTOR_VALUABLES: TagKey<Block> =
            tag("metal_detector_valuables")

        private fun tag(name: String): TagKey<Block> {
            return BlockTags.create(
                ResourceLocation(PolarisMod.MODID, name)
            )
        }
    }

    object Items {

        private fun tag(name: String): TagKey<Item> {
            return ItemTags.create(
                ResourceLocation(PolarisMod.MODID, name)
            )
        }
    }
}
