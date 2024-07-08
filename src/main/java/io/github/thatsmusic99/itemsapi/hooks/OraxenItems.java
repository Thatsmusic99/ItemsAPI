package io.github.thatsmusic99.itemsapi.hooks;

import io.github.thatsmusic99.itemsapi.api.ItemAPI;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Uses oraxen. Format: oraxen:item_id
 */
public class OraxenItems implements ItemAPI {

    @Override
    public @Nullable ItemStack getItem(@NotNull String input, @Nullable Player player) {
        return io.th0rgal.oraxen.api.OraxenItems.getItemById(input).build();
    }

    @Override
    public @Nullable String getID(@NotNull ItemStack item) {
        return io.th0rgal.oraxen.api.OraxenItems.getIdByItem(item);
    }

    @Override
    public @Nullable String getRequiredPluginName() {
        return "oraxen";
    }

    @Override
    public boolean usable(@NotNull String input) {
        return io.th0rgal.oraxen.api.OraxenItems.exists(input);
    }

}
