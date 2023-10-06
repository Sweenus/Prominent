package elocindev.prominent.fabric_quilt.item.artifacts;

import java.util.List;

import elocindev.prominent.fabric_quilt.ProminentLoader;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.sweenus.simplyswords.item.custom.ThunderbrandSwordItem;
import net.sweenus.simplyswords.util.HelperMethods;

public class GaiaSword extends ThunderbrandSwordItem {

    public GaiaSword(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, 
        (int)ProminentLoader.Config.gaiaSword_damage, ProminentLoader.Config.gaiaSword_attackSpeed, 
        settings);
    }
    
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        Style RIGHTCLICK = HelperMethods.getStyle("rightclick");
        Style ABILITY = HelperMethods.getStyle("ability");
        Style TEXT = HelperMethods.getStyle("text");

        tooltip.add(Text.literal("Artifact"));
        tooltip.add(Text.literal(""));
        tooltip.add(Text.translatable("item.simplyswords.thunderbrandsworditem.tooltip1").setStyle(ABILITY));
        tooltip.add(Text.translatable("item.simplyswords.thunderbrandsworditem.tooltip2").setStyle(TEXT));
        tooltip.add(Text.literal(""));
        tooltip.add(Text.translatable("item.simplyswords.onrightclickheld").setStyle(RIGHTCLICK));
        tooltip.add(Text.translatable("item.simplyswords.thunderbrandsworditem.tooltip3").setStyle(TEXT));
        tooltip.add(Text.translatable("item.simplyswords.thunderbrandsworditem.tooltip4").setStyle(TEXT));
        tooltip.add(Text.literal(""));
        tooltip.add(Text.translatable("item.simplyswords.thunderbrandsworditem.tooltip5").setStyle(TEXT));
        tooltip.add(Text.translatable("item.simplyswords.thunderbrandsworditem.tooltip6").setStyle(TEXT));
        tooltip.add(Text.translatable("item.simplyswords.thunderbrandsworditem.tooltip7").setStyle(TEXT));
        if (scalesWithSpellPower) {
            tooltip.add(Text.literal(""));
            tooltip.add(Text.translatable("item.simplyswords.compat.scaleLightning"));
        }
    }
}
