package io.plumium.items;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
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

    default boolean isCustom(ItemStack item) {
        // Если у предмета есть запись об ID, тогда это кастомный предмет.
        return item.getPersistentDataContainer().has(ITEM_ID_KEY,  PersistentDataType.STRING);
    }

    @Nullable
    default String getID(ItemStack item) {
        return item.getPersistentDataContainer().get(ITEM_ID_KEY,  PersistentDataType.STRING);
    }

    default Rarity getRarity(ItemStack item) {
        String rarity = item.getPersistentDataContainer().get(ITEM_RARITY_KEY,  PersistentDataType.STRING);
        /*
        Если нет записи о редкости, то это стандартный предмет Minecraft и его редкость определяется на основе
        цвета его названия (на момент 1.21.1 их всего 4).
        */
        if (rarity == null) {
            TextColor color = item.displayName().color();
            // Цвет у названия предмета вроде как не бывает null, но метод помечен как @Nullable.
            if (color == null) return Rarity.COMMON;
            // В качестве ключей используются значения констант из NamedTextColor.
            switch (color.value()) {
                case 0xffff55 -> {
                    return Rarity.UNCOMMON;
                }
                case 0x55ffff -> {
                    return Rarity.RARE;
                }
                case 0xff55ff -> {
                    return Rarity.EPIC;
                }
                default -> {
                    return Rarity.COMMON; // 0xffffff
                }
            }
        }
        // Если запись о редкости имеется, то это кастомный предмет.
        switch (rarity) {
            case "uncommon" -> {
                return Rarity.UNCOMMON;
            }
            case "rare" -> {
                return Rarity.RARE;
            }
            case "epic" -> {
                return Rarity.EPIC;
            }
            case "legendary" -> {
                return Rarity.LEGENDARY;
            }
            case "artefact" -> {
                return Rarity.ARTEFACT;
            }
            case "wonderful" -> {
                return Rarity.WONDERFUL;
            }
            default -> {
                return Rarity.COMMON;
            }
        }
    }

    /**
     * У кастомных предметов цвет имени может не совпадать с цветом скобок, которые сервер возвращает при вызове
     * displayName().
     * Пример: imgur.com/a/Q7V8ABx
     * Поэтому, если предмет кастомный (у него есть запись о редкости), нужно окрасить "[Предмет]" в
     * цвет его редкости.
     */
    default Component getDisplayName(ItemStack item) {
        String rarity = item.getPersistentDataContainer().get(ITEM_RARITY_KEY,  PersistentDataType.STRING);
        if (rarity == null) {
            return item.displayName();
        }
        return item.displayName().style(getRarity(item).getStyle());
    }

    ItemStack getItem(String customItemId);

    String getTranslation(String translationKey);
}
