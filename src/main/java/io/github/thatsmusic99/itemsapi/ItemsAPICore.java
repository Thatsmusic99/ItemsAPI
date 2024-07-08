package io.github.thatsmusic99.itemsapi;

import io.github.thatsmusic99.itemsapi.api.ItemAPI;
import io.github.thatsmusic99.itemsapi.hooks.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ItemsAPICore {

    private static ItemsAPICore core;
    private final List<ItemAPI> apis;

    public ItemsAPICore() {
        this.apis = new ArrayList<>();

        registerAPI(new HeadDatabaseItems());
        registerAPI(new HeadsPlusItems());
        registerAPI(new ItemsAdderItems());
        registerAPI(new MythicItems());
        registerAPI(new OraxenItems());
        registerAPI(new VanillaItems());
        registerAPI(new BukkitItems());
    }

    private void registerAPI(ItemAPI api) {
        this.apis.add(api);
    }

    public @Nullable ItemStack getItem(final @NotNull String input, final @Nullable Player player) {

        // Go through each API
        for (ItemAPI api : this.apis) {

            // Make sure any plugin that the API relies on is enabled
            if (api.getRequiredPluginName() != null &&
                    !Bukkit.getServer().getPluginManager().isPluginEnabled(api.getRequiredPluginName()))
                continue;

            // Check for the prefix and remove it if viable
            String id = input;
            if (api.getNamespace() != null) {
                if (!input.startsWith(api.getNamespace() + ":")) continue;
                id = input.replaceFirst(api.getRequiredPluginName() + ":", "");
            }

            // Check if the API in question can parse this input
            if (!api.usable(id)) continue;
            return api.getItem(id);
        }

        return null;
    }

    public @Nullable ItemStack getItem(final @NotNull String input) {

        return getItem(input, null);
    }

    public @Nullable String getID(final @NotNull ItemStack item) {

        // Go through each API
        for (ItemAPI api : this.apis) {

            // Make sure any plugin that the API relies on is enabled
            if (api.getRequiredPluginName() != null &&
                    !Bukkit.getServer().getPluginManager().isPluginEnabled(api.getRequiredPluginName()))
                continue;

            // Store the result and ensure it's not null
            final String id = api.getID(item);
            if (id == null) continue;
            return api.getNamespace() == null ? id : api.getNamespace() + ":" + id;
        }

        return null;
    }

    public static ItemsAPICore get() {
        if (core == null) core = new ItemsAPICore();
        return core;
    }
}
