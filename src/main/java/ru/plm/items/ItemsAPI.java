package ru.plm.items;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

@SuppressWarnings("unused")
public interface ItemsAPI {

    NamespacedKey ITEM_ID_KEY = new NamespacedKey("plm-items", "id");
    PersistentDataType<String, String> ITEM_ID_KEY_TYPE = PersistentDataType.STRING;

    NamespacedKey ITEM_RARITY_KEY = new NamespacedKey("plm-items", "rarity");
    PersistentDataType<String, String> ITEM_RARITY_KEY_TYPE = PersistentDataType.STRING;

    boolean isCustom(ItemStack item);

    @Nullable
    String getID(ItemStack item);

    @NotNull
    Rarity getRarity(ItemStack item);

    @NotNull
    Component getDisplayName(ItemStack item);

    @NotNull
    ItemStack getItem(String customItemId);

    @NotNull
    String getTranslation(String translationKey);
}
