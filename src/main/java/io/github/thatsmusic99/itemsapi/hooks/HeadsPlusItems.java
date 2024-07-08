package io.github.thatsmusic99.itemsapi.hooks;

import io.github.thatsmusic99.headsplus.HeadsPlus;
import io.github.thatsmusic99.headsplus.managers.HeadManager;
import io.github.thatsmusic99.itemsapi.api.ItemAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HeadsPlusItems implements ItemAPI {

    @Nullable
    @Override
    public ItemStack getItem(@NotNull String input, @Nullable Player player) {
        final var head = HeadManager.get().getHeadInfo(input);
        if (head == null) return null;
        return head.forceBuildHead();
    }

    @Nullable
    @Override
    public String getID(@NotNull ItemStack item) {

        // If it's not a player head, stop there
        if (item.getType() != Material.PLAYER_HEAD) return null;

        // Get the skull meta
        SkullMeta meta = (SkullMeta) item.getItemMeta();

        // Get the texture
        String texture = HeadsPlus.get().getProfileHandler().getTexture(meta);
        return HeadManager.get().getId(texture);
    }

    @Nullable
    @Override
    public String getRequiredPluginName() {
        return "HeadsPlus";
    }

    @Override
    public boolean usable(@NotNull String input) {
        return HeadManager.get().contains(input);
    }
}
