package io.github.thatsmusic99.itemsapi.tests;

import io.github.thatsmusic99.itemsapi.hooks.BukkitItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BukkitItemsTest {

    @Test
    public void test_allItems() {

        // FOR TEST PURPOSES ONLY - USE THE CORE CLASS.
        final BukkitItems api = new BukkitItems();

        // Go through each item
        for (Material material : Material.values()) {

            // Get the ID
            final String id = material.name();
            final ItemStack item = api.getItem(id);
            Assertions.assertNotNull(item);
            final String convertedId = api.getID(item);

            Assertions.assertEquals(id, convertedId);
        }
    }
}
