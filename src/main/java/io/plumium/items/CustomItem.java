package io.plumium.items;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

public abstract class CustomItem {

    protected String id;
    protected NamespacedKey namespacedKey;
    protected ItemStack itemStack;

    public String getId() {
        return id;
    }

    public NamespacedKey getNamespacedKey() {
        return namespacedKey;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}
