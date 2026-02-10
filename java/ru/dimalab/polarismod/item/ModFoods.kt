package ru.dimalab.polarismod.item

import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.food.FoodProperties

object ModFoods {

    @JvmField
    val STRAWBERRY: FoodProperties = FoodProperties.Builder()
        .nutrition(2)
        .fast()
        .saturationMod(0.2f)
        .effect({ MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200) }, 0.1f)
        .build()
}
