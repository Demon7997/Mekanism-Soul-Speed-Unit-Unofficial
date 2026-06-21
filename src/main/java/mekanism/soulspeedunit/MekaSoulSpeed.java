package mekanism.soulspeedunit;

import mekanism.api.gear.ModuleData;
import mekanism.common.Mekanism;
import mekanism.common.MekanismItems;
import mekanism.common.content.gear.ModuleHelper;
import mekanism.common.item.ItemModule;
import mekanism.soulspeedunit.common.CommonProxy;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = "mekasoulspeed", name = "Mekanism Soul Speed Unit", version = "1.0.0", dependencies = "required-after:mekanism;required-after:nb")
@Mod.EventBusSubscriber(modid = "mekasoulspeed")
public class MekaSoulSpeed {

    @SidedProxy(clientSide = "mekanism.soulspeedunit.client.ClientProxy", serverSide = "mekanism.soulspeedunit.common.CommonProxy")
    public static CommonProxy proxy;

    public static ModuleData<?> SOUL_SPEED_UNIT;
    public static Item MODULE_SOUL_SPEED;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        SOUL_SPEED_UNIT = ModuleHelper.registerEnchantBased("soul_speed_unit", 
            () -> Enchantment.getEnchantmentByLocation("nb:soul_speed"), 
            builder -> builder.maxStackSize(3).rarity(EnumRarity.RARE));

        MODULE_SOUL_SPEED = new ItemModule(SOUL_SPEED_UNIT)
            .setTranslationKey("module_soul_surfer_unit")
            .setRegistryName(new ResourceLocation("mekasoulspeed", "module_soul_surfer_unit"))
            .setCreativeTab(Mekanism.tabMekanism);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(MODULE_SOUL_SPEED);
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        proxy.registerModels();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModuleHelper.get().setSupported(MekanismItems.MEKASUIT_BOOTS, SOUL_SPEED_UNIT);
    }
}
