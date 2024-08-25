package io.plumium.items;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static net.kyori.adventure.text.Component.text;

public class CustomItem extends ItemStack {

    protected String id;
    protected Rarity rarity;
    protected ItemMeta itemMeta;
    protected Component displayName;

    public CustomItem(@NotNull final Material type,
                      @NotNull final String id,
                      @NotNull final String name,
                      @NotNull final Rarity rarity,
                      @NotNull ItemsAPI itemsAPI) {
        super(type);
        itemMeta = super.getItemMeta();
        this.id = id;
        this.rarity = rarity;
        displayName = text()
                .color(rarity.getColor())
                .append(text("["))
                .append(text(name))
                .append(text("]"))
                .hoverEvent(asHoverEvent())
                .build();
        itemsAPI.registerCustomItem(this);
    }

    @Override
    public @NotNull Component displayName() {
        return displayName;
    }

    @Override
    public @NotNull ItemMeta getItemMeta() {
        return itemMeta;
    }

    @Override
    public boolean setItemMeta(@Nullable ItemMeta itemMeta) {
        this.itemMeta = itemMeta;
        return super.setItemMeta(itemMeta);
    }

    public String getId() {
        return id;
    }

    public Rarity getCustomRarity() {
        return rarity;
    }
}
