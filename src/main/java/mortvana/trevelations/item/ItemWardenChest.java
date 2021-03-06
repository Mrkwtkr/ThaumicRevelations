package mortvana.trevelations.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mortvana.trevelations.common.TRevelations;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class ItemWardenChest extends ItemWardenArmor {

    public ItemWardenChest() {

        super(1);
        setUnlocalizedName("itemWardenChest");
        setCreativeTab(TRevelations.tabTRevelations);

    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {

        itemIcon = register.registerIcon("trevelations:wardenchest");

    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {

        return "trevelations:textures/models/warden_1.png";

    }

}
