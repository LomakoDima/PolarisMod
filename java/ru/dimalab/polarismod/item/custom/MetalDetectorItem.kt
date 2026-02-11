package ru.dimalab.polarismod.item.custom

import net.minecraft.client.resources.language.I18n
import net.minecraft.core.BlockPos
import net.minecraft.network.chat.Component
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.item.context.UseOnContext
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockState
import ru.dimalab.polarismod.util.ModTags

class MetalDetectorItem(properties: Properties) : Item(properties) {

    override fun useOn(context: UseOnContext): InteractionResult {

        val level = context.level
        val player = context.player
        val positionClicked = context.clickedPos

        if (!level.isClientSide) {

            var foundBlock = false

            for (i in 0..positionClicked.y + 64) {
                val state = level.getBlockState(positionClicked.below(i))

                if (isValuableBlock(state)) {
                    if (player != null) {
                        outputValuableCoordinates(
                            positionClicked.below(i),
                            player,
                            state.block
                        )
                    }
                    foundBlock = true
                    break
                }
            }

            if (!foundBlock && player != null) {
                player.sendSystemMessage(Component.literal("No valuables Found!"))
            }
        }

        player?.let {
            context.itemInHand.hurtAndBreak(1, it) { p ->
                p.broadcastBreakEvent(p.usedItemHand)
            }
        }

        return InteractionResult.SUCCESS
    }

    private fun outputValuableCoordinates(
        blockPos: BlockPos,
        player: Player,
        block: Block
    ) {
        player.sendSystemMessage(
            Component.literal(
                "Found ${I18n.get(block.descriptionId)} at " +
                        "(${blockPos.x}, ${blockPos.y}, ${blockPos.z})"
            )
        )
    }

    override fun appendHoverText(
        stack: ItemStack,
        level: Level?,
        tooltip: MutableList<Component>,
        flag: TooltipFlag
    ) {
        tooltip.add(
            Component.translatable("tooltip.polarismod.metal_detector.tooltip")
        )

        super.appendHoverText(stack, level, tooltip, flag)
    }

    private fun isValuableBlock(state: BlockState): Boolean {
        return state.`is`(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
    }
}
