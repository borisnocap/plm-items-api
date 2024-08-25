package ru.plm.items;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

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

    Rarity getRarity(ItemStack item);

    Component getDisplayName(ItemStack item);

    ItemStack getItem(String customItemId);

    String getTranslation(String translationKey);
}
