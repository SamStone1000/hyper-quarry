package stone.hyperquarry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import stone.hyperquarry.client.GuiFilter;
import stone.hyperquarry.client.GuiQuarry;
import stone.hyperquarry.common.Filter;

public class Client extends Server {
	@Override
	public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        // I hate Minecraft
        ModelLoader.setCustomModelResourceLocation(HyperQuarry.QUARRY_ITEM, 0,
                                                   new ModelResourceLocation("hyper_quarry:quarry", "inventory"));
    }

    // super jank, but can't be bothered to do it the correct way
    // (send te data to client, then have client make gui or something)
    public static void showFilterScreen(Filter filter) {
        Minecraft.getMinecraft().displayGuiScreen(new GuiFilter(filter));
    }

    public static void displayQuarryGui(BlockPos target, long mined, boolean isRunning, int cost) {
        Minecraft.getMinecraft().displayGuiScreen(new GuiQuarry(target, mined, isRunning, cost));
    }
	
}
