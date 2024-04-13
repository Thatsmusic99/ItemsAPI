package io.github.thatsmusic99.itemsapi.hooks;

import io.github.thatsmusic99.itemsapi.api.ItemAPI;
import me.arcaniax.hdb.api.HeadDatabaseAPI;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Uses HeadDatabase. Format: hdb:head_id
 */
public class HeadDatabaseItems implements ItemAPI {

    private final @NotNull HeadDatabaseAPI api;

    public HeadDatabaseItems() {
        this.api = new HeadDatabaseAPI();
    }

    @Override
    public @NotNull ItemStack getItem(@NotNull String input) {
        return api.getItemHead(input);
    }

    @Override
    public @Nullable String getID(@NotNull ItemStack item) {
        return api.getItemID(item);
    }

    @Override
    public @Nullable String getRequiredPluginName() {
        return "HeadDatabase";
    }

    @Nullable
    @Override
    public String getNamespace() {
        return "hdb";
    }

    @Override
    public boolean usable(@NotNull String input) {
        return api.isHead(input);
    }
}
