package com.monkeysquad.hungergames.fluid;
import net.fabricmc.fabric.impl.tag.convention.TagRegistration;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;


public class GreenLavaFluid extends LavaFluid {


    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_GREEN_LAVA;
    }

    @Override
    public Fluid getStill() {
        return ModFluids.STILL_GREEN_LAVA;
    }

    private boolean isStone(Block block) {
        return block == Blocks.STONE;
    }
    @Override
    public boolean canBeReplacedWith(FluidState state, BlockView blockView, BlockPos blockPos, Fluid fluid, Direction direction) {
        return state.isStill() || isStone(state.getBlockState().getBlock());
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        super.beforeBreakingBlock(world, pos, state);
    }

    @Override
    public int getFlowSpeed(WorldView world) {
        return 4;
    }

    @Override
    public int getLevelDecreasePerBlock(WorldView world) {
        return 1;
    }

    @Override
    protected boolean hasRandomTicks() {
        return true;
    }

    @Override
    public int getTickRate(WorldView world) {
        return 5;
    }

    @Override
    protected float getBlastResistance() {
        return 100.0F;
    }

    @Override
    public BlockState toBlockState(FluidState fluidState) {
        return ModFluids.STILL_GREEN_LAVA.getDefaultState().with(FluidBlock.LEVEL, getBlockStateLevel(fluidState)).getBlockState();
    }

    @Override
    public boolean isStill(FluidState state) {
        return false;
    }

    @Override
    public int getLevel(FluidState fluidState) {
        return fluidState.getLevel();
    }

    @Override
    public FluidState getFlowing(int level, boolean falling) {
        return super.getFlowing(level, falling);
    }

    @Override
    protected boolean isInfinite(World world) {
        return false;
    }
}
