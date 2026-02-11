package ru.dimalab.polarismod.block.custom

import net.minecraft.core.BlockPos
import net.minecraft.network.chat.Component
import net.minecraft.sounds.SoundEvents
import net.minecraft.sounds.SoundSource
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult

class SoundBlock(properties: Properties) : Block(properties) {

    override fun use(
        state: BlockState,
        level: Level,
        pos: BlockPos,
        player: Player,
        hand: InteractionHand,
        hit: BlockHitResult
    ): InteractionResult {

        level.playSound(
            player,
            pos,
            SoundEvents.NOTE_BLOCK_DIDGERIDOO.value(),
            SoundSource.BLOCKS,
            1f,
            1f
        )

        return InteractionResult.SUCCESS
    }

    override fun appendHoverText(
        stack: ItemStack,
        level: BlockGetter?,
        tooltip: MutableList<Component>,
        flag: TooltipFlag
    ) {
        tooltip.add(
            Component.literal("Makes sweet sounds when right-clicked!")
        )

        super.appendHoverText(stack, level, tooltip, flag)
    }
}
