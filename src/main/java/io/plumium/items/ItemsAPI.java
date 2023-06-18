package io.plumium.items;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;

public interface ItemsAPI {

    CustomItem PLUMCOIN();

    CustomItem OVERWORLD_CHUNK();

    CustomItem NETHER_CHUNK();

    CustomItem THE_END_CHUNK();

    Component getItemDisplayName(ItemStack item);
}
