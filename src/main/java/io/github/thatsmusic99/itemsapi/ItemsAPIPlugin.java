package io.github.thatsmusic99.itemsapi;

import org.bukkit.plugin.java.JavaPlugin;

public class ItemsAPIPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        ItemsAPICore.get();
    }
}
