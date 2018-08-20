package com.github.upcraftlp.wastelands.init;

import com.github.upcraftlp.wastelands.ExtremeWastelands;
import com.github.upcraftlp.wastelands.item.ItemBattery;
import ladylib.registration.AutoRegister;
import net.minecraft.item.Item;

@AutoRegister(ExtremeWastelands.MODID)
public class WastelandItems {

    //aluminum
    @AutoRegister.Ore("ingotAluminum")
    public static final Item ALUMINUM_INGOT = new Item();
    @AutoRegister.Ore("nuggetAluminum")
    public static final Item ALUMINUM_NUGGET = new Item();
    @AutoRegister.Ore("dustAluminum")
    public static final Item ALUMINUM_DUST = new Item();
    @AutoRegister.Ore("plateAluminum")
    public static final Item ALUMINUM_PLATE = new Item();
    @AutoRegister.Ore("rodAluminum")
    public static final Item ALUMINUM_ROD = new Item();

    //lead
    @AutoRegister.Ore("ingotLead")
    public static final Item LEAD_INGOT = new Item();
    @AutoRegister.Ore("nuggetLead")
    public static final Item LEAD_NUGGET = new Item();
    @AutoRegister.Ore("dustLead")
    public static final Item LEAD_DUST = new Item();
    @AutoRegister.Ore("plateLead")
    public static final Item LEAD_PLATE = new Item();
    @AutoRegister.Ore("rodLead")
    public static final Item LEAD_ROD = new Item();

    //batteries
    public static final Item LEAD_BATTERY = new ItemBattery(64000, 32, 512);
    public static final Item NUCLEAR_BATTERY = new ItemBattery(1000000, 0, 1024);
}
