package io.github.thatsmusic99.itemsapi.api;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents an item API.
 */
public interface ItemAPI {

    /**
     * Fetches an item with the string input provided.
     *
     * @param input
     * @return
     */
    @Nullable ItemStack getItem(@NotNull String input);

    @Nullable String getID(@NotNull ItemStack item);

    @Nullable String getRequiredPluginName();

    default @Nullable String getNamespace() {
        return getRequiredPluginName() == null ? null : getRequiredPluginName().toLowerCase();
    }

    /**
     * Whether a certain input can be parsed by a plugin, often checking their prefix and if an item is stored internally.
     *
     * @param input the ID of the
     * @return
     */
    boolean usable(@NotNull String input);
}
