package mekanism.soulspeedunit.client;

import mekanism.soulspeedunit.common.CommonProxy;
import mekanism.soulspeedunit.MekaSoulSpeed;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void registerModels() {
        ModelLoader.setCustomModelResourceLocation(MekaSoulSpeed.MODULE_SOUL_SPEED, 0, 
            new ModelResourceLocation(MekaSoulSpeed.MODULE_SOUL_SPEED.getRegistryName(), "inventory"));
    }
}
