package io.plumium.items;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static net.kyori.adventure.text.Component.text;

public class CustomItem extends ItemStack implements Cloneable {

    private final String id;
    private final String name;
    private final Rarity rarity;
    private ItemMeta itemMeta;
    private Component displayName;

    public CustomItem(@NotNull ItemsAPI itemsAPI,
                      @NotNull final Material type,
                      @NotNull final String id,
                      @NotNull final String name,
                      @NotNull final Rarity rarity) {
        super(type);
        itemMeta = super.getItemMeta();
        this.id = id;
        this.name = name;
        this.rarity = rarity;
        displayName = generateDisplayName();


        itemsAPI.registerCustomItem(this);
    }

    private Component generateDisplayName() {
        return text()
                .color(rarity.getColor())
                .append(text("["))
                .append(text(name))
                .append(text("]"))
                .hoverEvent(asHoverEvent())
                .build();
    }

    public String getId() {
        return id;
    }

    public Rarity getCustomRarity() {
        return rarity;
    }

    @Override
    public @NotNull Component displayName() {
        return displayName;
    }

    /**
     * При вызове getItemMeta() у ItemStack возвращается копия ItemMeta.
     * Чтобы не создавать копию для каждого вызова getItemMeta у CustomItem, я кэширую актуальную мету.
     */
    @Override
    public @NotNull ItemMeta getItemMeta() {
        return itemMeta;
    }

    /**
     * При изменении меты у CustomItem мне нужно сохранить актуальное значение в кэш.
     */
    @Override
    public boolean setItemMeta(@Nullable ItemMeta itemMeta) {
        boolean result = super.setItemMeta(itemMeta);
        if (!result) return false;
        this.itemMeta = itemMeta;
        displayName = generateDisplayName();;
        return true;
    }

    @Override
    public @NotNull CustomItem clone() {
        return (CustomItem) super.clone();
    }
}
