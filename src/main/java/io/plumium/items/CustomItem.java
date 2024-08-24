package io.plumium.items;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public abstract class CustomItem extends ItemStack {

    protected String id;
    protected Rarity rarity;
    protected Component displayName;

    public CustomItem(@NotNull final Material type) {
        super(type);
    }

    public String getId() {
        return id;
    }

    @Override
    public @NotNull Component displayName() {
        return displayName;
    }
}
