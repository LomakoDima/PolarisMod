package ru.dimalab.polarismod.item.custom

import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.crafting.RecipeType

class FuelItem(
    properties: Properties,
    private val burnTime: Int
) : Item(properties) {

    override fun getBurnTime(
        itemStack: ItemStack,
        recipeType: RecipeType<*>?
    ): Int {
        return burnTime
    }
}