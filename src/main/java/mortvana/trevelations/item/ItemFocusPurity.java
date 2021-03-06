package mortvana.trevelations.item;

import mortvana.trevelations.common.TRevelations;
import mortvana.trevelations.entity.EntityPurity;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.wands.ItemFocusBasic;
import thaumcraft.common.items.wands.ItemWandCasting;

public class ItemFocusPurity extends ItemFocusBasic {

    private IIcon depth, orn;

    public ItemFocusPurity() {

        super();
        setUnlocalizedName("itemFocusPurity");
        setCreativeTab(TRevelations.tabTRevelations);

    }

    @Override
    public void registerIcons(IIconRegister register) {

        icon = register.registerIcon("trevelations:purityfocus");
        depth = register.registerIcon("trevelations:puritydepth");
        orn = register.registerIcon("trevelations:purityorn");

    }

    @Override
    public IIcon getFocusDepthLayerIcon() {return depth;}

    @Override
    public IIcon getOrnament() {return orn;}

    @Override
    public int getFocusColor() {return 0x6698FF;}

    public ItemStack onFocusRightClick(ItemStack itemStack, World world, EntityPlayer player, MovingObjectPosition mop) {

        ItemWandCasting wand = (ItemWandCasting)itemStack.getItem();
        EntityPurity purityOrb = new EntityPurity(world, player);

        if (!world.isRemote) {

            if (wand.consumeAllVis(itemStack, player, getVisCost(), true, false)) {

                world.spawnEntityInWorld(purityOrb);
                world.playSoundAtEntity(purityOrb, "thaumcraft:ice", 0.3F, 0.8F + world.rand.nextFloat() * 0.1F);

            }

        }

        player.swingItem();

        return itemStack;

    }

    @Override
    public String getSortingHelper(ItemStack itemStack) {return "PURITY";}

    @Override
    public AspectList getVisCost() {

        return new AspectList().add(Aspect.AIR, 500).add(Aspect.EARTH, 500).add(Aspect.FIRE, 500)
            .add(Aspect.WATER, 500).add(Aspect.ORDER, 500).add(Aspect.ENTROPY, 500);

    }

}
