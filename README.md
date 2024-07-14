# ItemsAPI
A lightweight items API that hooks into plugins that add unique or custom-made items that can be used in other plugins,
by converting IDs that plugins use internally to items.

This library can be used with 1.18+.

You can use this for:
- Usage of custom items in a GUI.
- Checking if an item from another plugin is in a player's inventory.
- Rewards from crates or missions.

## Inbuilt Support
Inbuilt support is provided for:
- HeadDatabase
- HeadsPlus
- ItemsAdder
- MMOItems
- MythicMobs
- oraxen
- Bukkit
- Vanilla

Please note that Spigot/Paper will generate a warning about these plugins if you do not add them as a dependency in your 
plugin.yml file. If one of the above plugins already depends on your own though, don't add it as it will result in a 
circular dependency.

Since some of these plugins are premium as well, ItemsAPI only hooks into their API - I do not have in-depth knowledge 
about how the premium plugins work. If any issues are noticed with any implementations, please open an issue.

## API Usage

```kotlin
repositories {
    maven("https://repo.bsdevelopment.org/releases/")
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
Some APIs can make items vary depending on a certain player as well, so you can pass in a player too:
```java
final ItemStack item = ItemsAPICore.get().getItem("hdb:83912", Bukkit.getPlayer("Thatsmusic99"));
```

### HeadDatabase
Referenced using `hdb:ID`, e.g. `hdb:83192`.

### HeadsPlus
References all registered head objects, e.g.:
- `headsplus:wood_a`
- `headsplus:HP#wood_a`
- `headsplus:HPM#chicken`

The only difference between the first two is the syntax - `HP#` is often used to refer to other heads internally in the
plugin configuration, but is optional when ItemsAPI is being used. `HPM#` indicates to pick a mask head, which applies
effects when worn on a player's head.

### ItemsAdder
Referenced using `itemsadder:namespace:id` or `itemsadder:id`, e.g. `itemsadder:emerald_sword`.

### MMOItemsdi

### MythicMobs

### oraxen

### Bukkit

### Vanilla

