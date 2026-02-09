package ru.dimalab.polarismod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import ru.dimalab.polarismod.PolarisMod;
import ru.dimalab.polarismod.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PolarisMod.MODID);

    public static final RegistryObject<CreativeModeTab> POLARIS_TAB = CREATIVE_MODE_TABS.register("polaris_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.INSTANCE.getSAPPHIRE().get()))
                    .title(Component.translatable("creativetab.polaris_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.INSTANCE.getSAPPHIRE().get());
                        pOutput.accept(ModItems.INSTANCE.getRAW_SAPPHIRE().get());

                        pOutput.accept(ModItems.INSTANCE.getMETAL_DETECTOR().get());

                        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());

                        pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.NETHER_SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.END_STONE_SAPPHIRE_ORE.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
