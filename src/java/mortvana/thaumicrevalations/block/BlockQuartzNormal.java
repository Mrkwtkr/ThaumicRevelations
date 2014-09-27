package mortvana.thaumicrevalations.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mortvana.thaumicrevalations.TRevalations;
import mortvana.thaumicrevalations.lib.BlockLib;
import mortvana.thaumicrevalations.lib.ModLib;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockQuartzNormal extends Block {

    public IIcon topIcon;
    public IIcon botIcon;
    public IIcon sideIcon;

    protected BlockQuartzNormal() {

        super(Material.rock);
        setBlockName(BlockLib.QUARTZ_NORMAL_NAME);
        setCreativeTab(TRevalations.tabTWarden);
        setStepSound(Block.soundTypeStone);
        setHardness(0.8F);

    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {

        topIcon = register.registerIcon(ModLib.ID.toLowerCase() + ":" + "infusedquartztop" );
        botIcon = register.registerIcon(ModLib.ID.toLowerCase() + ":" + "infusedquartzbot" );
        sideIcon = register.registerIcon(ModLib.ID.toLowerCase() + ":" + "infusedquartzside" );

    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {

        if(side == 0) {

            return botIcon;

        } else if(side == 1) {

            return topIcon;

        } else {

            return sideIcon;

        }

    }

}