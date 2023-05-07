package io.plumium.items;

import org.bukkit.inventory.ItemStack;

public abstract class CustomItem {

    protected String id;
    protected ItemStack itemStack;

    public String getId() {
        return id;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}
