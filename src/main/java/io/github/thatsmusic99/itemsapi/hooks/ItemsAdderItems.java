package io.github.thatsmusic99.itemsapi.hooks;

import dev.lone.itemsadder.api.CustomStack;
import io.github.thatsmusic99.itemsapi.api.ItemAPI;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Uses ItemsAdder. Format: itemsadder:namespace:id
 */
public class ItemsAdderItems implements ItemAPI {
    @Override
    public @Nullable ItemStack getItem(@NotNull String input, @Nullable Player player) {
        CustomStack item = CustomStack.getInstance(input);
        return item == null ? null : item.getItemStack();
    }

    @Override
    public @Nullable String getID(@NotNull ItemStack item) {
        CustomStack stack = CustomStack.byItemStack(item);
        return stack == null ? null : stack.getId();
    }

    @Override
    public @Nullable String getRequiredPluginName() {
        return "ItemsAdder";
    }

    @Override
    public boolean usable(@NotNull String input) {
        return CustomStack.isInRegistry(input);
    }
}
