package com.monkeysquad.hungergames.fluid;

import com.monkeysquad.hungergames.HungerGames;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class FluidRenderHandler implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        FluidRenderHandlerRegistry.INSTANCE.register(HungerGames.STILL_ACID, HungerGames.FLOWING_ACID, new SimpleFluidRenderHandler(
                new Identifier("hungergames:block/still_green_lava"),
                new Identifier("hungergames:block/flowing_green_lava"),
                0x4CC248
        ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), HungerGames.STILL_ACID, HungerGames.FLOWING_ACID);
    }
}
