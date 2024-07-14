package io.github.thatsmusic99.itemsapi.hooks;

import io.github.thatsmusic99.itemsapi.api.ItemAPI;
import io.lumine.mythic.lib.api.item.NBTItem;
import net.Indyuce.mmoitems.MMOItems;
import net.Indyuce.mmoitems.api.Type;
import net.Indyuce.mmoitems.api.item.mmoitem.MMOItem;
import net.Indyuce.mmoitems.api.player.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Uses MMOItems. Format: mmoitems:type:id
 */
public class MMOItemsItems implements ItemAPI {

    @Override
    public @Nullable ItemStack getItem(@NotNull String input, @Nullable Player player) {

        final String[] parts = input.split(":");

        // Get the type and ensure it exists
        final Type type = MMOItems.plugin.getTypes().get(parts[0]);
        if (type == null) return null;

        // Now attempt to fetch the item
        final MMOItem item;
        if (player != null && PlayerData.has(player)) {
            final PlayerData data = PlayerData.get(player);
            item = MMOItems.plugin.getMMOItem(type, parts[1], data);
        } else {
            item = MMOItems.plugin.getMMOItem(type, parts[1]);
        }

        if (item == null) return null;

        return item.newBuilder().build();
    }

    @Override
    public @Nullable String getID(@NotNull ItemStack item) {

        NBTItem nbtItem = NBTItem.get(item);
        if (!nbtItem.hasType()) return null;

        final String id = nbtItem.getString("MMOITEMS_ITEM_ID");
        if (id == null) return null;

        return nbtItem.getType() + ":" + id;
    }

    @Override
    public @Nullable String getRequiredPluginName() {
        return "MMOItems";
    }

    @Override
    public boolean usable(@NotNull String input) {
        return input.split(":").length >= 2;
    }
}
