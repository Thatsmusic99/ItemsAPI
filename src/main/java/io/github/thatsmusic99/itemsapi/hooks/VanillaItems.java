package io.github.thatsmusic99.itemsapi.hooks;

import io.github.thatsmusic99.itemsapi.api.ItemAPI;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VanillaItems implements ItemAPI {

    @Override
    public @Nullable ItemStack getItem(@NotNull String input) {

        Registry<Material> materials = Registry.SimpleRegistry.MATERIAL;
        NamespacedKey key = NamespacedKey.fromString(input);
        if (key == null) return null;
        Material material = materials.get(key);
        if (material == null) return null;

        return new ItemStack(material);
    }

    @Override
    public @Nullable String getID(@NotNull ItemStack item) {
        return item.getType().getKey().asString();
    }

    @Override
    public @Nullable String getRequiredPluginName() {
        return null;
    }

    @Override
    public boolean usable(@NotNull String input) {
        return input.matches("^([a-z0-9/._-]+:)?[a-z0-9/._-]+");
    }
}
