package io.plumium.items;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public abstract class CustomItem {

    public static final NamespacedKey ITEM_ID = new NamespacedKey("plumium", "item_id");
    public static final NamespacedKey ITEM_TYPE = new NamespacedKey("plumium", "item_type");

    protected String id;
    protected ItemStack itemStack;

    public String getId() {
        return id;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}
