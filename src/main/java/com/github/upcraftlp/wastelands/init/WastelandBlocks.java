package com.github.upcraftlp.wastelands.init;

import com.github.upcraftlp.wastelands.ExtremeWastelands;
import ladylib.registration.AutoRegister;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(ExtremeWastelands.MODID)
@AutoRegister(ExtremeWastelands.MODID)
public class WastelandBlocks {

    public static final Block IRRADIATED_DIRT = new Block(Material.GROUND);

    @AutoRegister.Ore("oreAluminum")
    public static final Block ALUMINUM_ORE = new BlockOre();

    @AutoRegister.Ore("oreLead")
    public static final Block LEAD_ORE = new BlockOre();

}
