package com.robertx22.dungeon_realm.database.data_blocks.mobs;

import com.robertx22.dungeon_realm.main.DataBlockTags;
import com.robertx22.library_of_exile.database.map_data_block.MapDataBlock;
import com.robertx22.library_of_exile.database.mob_list.MobList;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class BossMB extends MapDataBlock {
    public BossMB(String id) {
        super(id, id);

        this.aliases.add("boss_mob");

        this.tags.add(DataBlockTags.CAN_SPAWN_LEAGUE);
    }

    @Override
    public void processImplementationINTERNAL(String s, BlockPos pos, Level level, CompoundTag nbt) {
        EntityType<? extends LivingEntity> type = MobList.PREDETERMINED.getPredeterminedRandom(level, pos).getRandomMob().getType();

        MobBuilder.of(type, this, x -> {
            x.amount = 1;
        }).summonMobs(level, pos);
    }

    @Override
    public Class<?> getClassForSerialization() {
        return BossMB.class;
    }
}
