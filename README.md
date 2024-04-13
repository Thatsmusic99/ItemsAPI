# ItemsAPI
A lightweight items API that hooks into plugins that add unique or custom-made items that can be used in other plugins.

You can use this for:
- Usage of custom items in a GUI.
- Checking if an item from another plugin is in a player's inventory.

## Inbuilt Support
Inbuilt support is provided for:
- HeadDatabase
- HeadsPlus
- ItemsAdder
- MythicMobs
- Oraxen
- Bukkit
- Vanilla

Please note that Spigot/Paper will generate a warning about these plugins if you do not add them as a dependency in your 
plugin.yml file.

## API Usage

```kotlin
repositories {
    maven("https://ci.pluginwiki.us/plugin/repository/everything/")
}

dependencies {
    implementation("io.github.thatsmusic99:ItemsAPI:1.0")
}
```
Individual APIs are not fetched individually - a central class is often used to access item APIs.
```java
final ItemStack hdbItem = ItemsAPICore.get().getItem("hdb:83912");
final String hdbId = ItemsAPICore.get().getID(hdbItem); // Returns hdb:83912
```


