package com.hakimen.peripherals.blocks;

import com.hakimen.peripherals.blocks.tile_entities.TradingInterfaceEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.Nullable;


public class TradingInterfaceBlock extends Block implements EntityBlock {
    public TradingInterfaceBlock() {
        super(Properties.of(Material.STONE).strength(2f,2f).sound(SoundType.STONE));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TradingInterfaceEntity(pos,state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> p_153214_) {
        return level.isClientSide ? null : ($0,$1,$2,blockEntity) -> {((TradingInterfaceEntity) blockEntity).tick();};
    }
}