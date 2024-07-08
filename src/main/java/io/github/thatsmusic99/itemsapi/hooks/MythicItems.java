package io.github.thatsmusic99.itemsapi.hooks;

import io.github.thatsmusic99.itemsapi.api.ItemAPI;
import io.lumine.mythic.api.MythicProvider;
import io.lumine.mythic.bukkit.adapters.BukkitItemStack;
import io.lumine.mythic.core.items.MythicItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * Uses MythicMobs. Format: mythicmobs:id
 */
public class MythicItems implements ItemAPI {

    @Override
    public @Nullable ItemStack getItem(@NotNull String input, @Nullable Player player) {
        final Optional<MythicItem> item = MythicProvider.get().getItemManager().getItem(input);

        if (item.isPresent()) {
            final BukkitItemStack bukkitStack = (BukkitItemStack) item.get().generateItemStack(1);
            return bukkitStack.build();
        } else {
            return null;
        }
    }

    @Override
    public @Nullable String getID(@NotNull ItemStack item) {

        return MythicProvider.get().getItemManager().getMythicTypeFromItem(item);
    }

    @Override
    public @Nullable String getRequiredPluginName() {
        return "MythicMobs";
    }

    @Override
    public boolean usable(@NotNull String input) {
        return MythicProvider.get().getItemManager().getItemNames().contains(input);
    }
}
