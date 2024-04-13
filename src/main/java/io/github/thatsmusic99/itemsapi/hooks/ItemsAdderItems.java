package io.github.thatsmusic99.itemsapi.hooks;

import dev.lone.itemsadder.api.CustomStack;
import dev.lone.itemsadder.api.ItemsAdder;
import io.github.thatsmusic99.itemsapi.api.ItemAPI;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Uses ItemsAdder. Format: itemsadder:namespace:id
 */
public class ItemsAdderItems implements ItemAPI {
    @Override
    public @Nullable ItemStack getItem(@NotNull String input) {

        final String[] id = input.split(":");
        if (id.length < 2) return null;

        final List<CustomStack> stacks = ItemsAdder.getAllItems(id[0]);
        for (CustomStack item : stacks) {
            if (!item.getId().equals(id[1])) continue;
            return item.getItemStack();
        }

        return null;
    }

    @Override
    public @Nullable String getID(@NotNull ItemStack item) {
        return ItemsAdder.getCustomItemName(item);
    }

    @Override
    public @Nullable String getRequiredPluginName() {
        return "ItemsAdder";
    }

    @Override
    public boolean usable(@NotNull String input) {
        return input.split(":").length >= 2;
    }
}
