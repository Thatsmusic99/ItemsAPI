package io.github.thatsmusic99.itemsapi.hooks;

import io.github.thatsmusic99.itemsapi.api.ItemAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BukkitItems implements ItemAPI {

    public BukkitItems() {

    }

    @Override
    public @Nullable ItemStack getItem(@NotNull String input, @Nullable Player player) {
        final Material material = Material.getMaterial(input.toUpperCase());
        if (material == null) return null;
        return new ItemStack(material);
    }

    @Override
    public @Nullable String getID(@NotNull ItemStack item) {
        return item.getType().name();
    }

    @Override
    public @Nullable String getRequiredPluginName() {
        return null;
    }

    @Override
    public boolean usable(@NotNull String input) {
        return true;
    }
}
