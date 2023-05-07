package io.plumium.items;

import org.bukkit.NamespacedKey;

public interface ItemsAPI {

    NamespacedKey ITEM_ID();

    NamespacedKey ITEM_TYPE();

    CustomItem PLUMCOIN();

    CustomItem OVERWORLD_CHUNK();

    CustomItem NETHER_CHUNK();

    CustomItem END_CHUNK();
}
