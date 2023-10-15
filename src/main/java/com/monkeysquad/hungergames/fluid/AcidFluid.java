package com.monkeysquad.hungergames.fluid;

import com.monkeysquad.hungergames.HungerGames;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;

public abstract class AcidFluid extends AcidFluidInitiation {
    @Override
    public Fluid getStill() {
        return HungerGames.STILL_ACID;
    }

    @Override
    public Fluid getFlowing() {
        return HungerGames.FLOWING_ACID;
    }

    @Override
    public Item getBucketItem() {
        return HungerGames.ACID_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState fluidState) {
        return HungerGames.ACID.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
    }

    public static class Flowing extends AcidFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }
    }

    public static class Still extends AcidFluid {
        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }
}