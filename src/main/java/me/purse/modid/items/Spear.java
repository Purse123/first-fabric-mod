package me.purse.modid.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Spear extends Item {
    public Spear(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.of("Your mom...Cyka Blyat"));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (hand == Hand.MAIN_HAND) {
            user.playSound(SoundEvents.BLOCK_ANCIENT_DEBRIS_PLACE, 1.0f, 1.0f);
            user.sendMessage(Text.of("Wosh"));
        } else {
            user.playSound(SoundEvents.BLOCK_ANVIL_HIT, 1.0f, 1.0f);
            user.setHealth(0);
            user.sendMessage(Text.of("you spear yourself!"));
        }

        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
