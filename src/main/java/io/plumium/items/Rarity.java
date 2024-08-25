package io.plumium.items;

import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.NamespacedKey;

import static net.kyori.adventure.text.format.NamedTextColor.*;

public enum Rarity {

    COMMON(WHITE),
    UNCOMMON(YELLOW),
    RARE(AQUA),
    EPIC(LIGHT_PURPLE),
    LEGENDARY(GOLD),
    ARTEFACT(RED),
    WONDERFUL(GREEN);

    public static final NamespacedKey RARITY_KEY = new NamespacedKey("plm-items", "rarity");

    private final Style style;
    private final int colorValue;


    Rarity(TextColor color) {
        this.style = Style.style().color(color).decoration(TextDecoration.ITALIC, false).build();
        colorValue = color.value();
    }

    public Style getStyle() {
        return style;
    }

    public TextColor getColor() {
        return style.color();
    }

}
