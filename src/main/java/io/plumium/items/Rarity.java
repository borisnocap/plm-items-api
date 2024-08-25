package io.plumium.items;

import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;

import static net.kyori.adventure.text.format.NamedTextColor.*;

public enum Rarity {

    COMMON(WHITE),
    UNCOMMON(YELLOW),
    RARE(AQUA),
    EPIC(LIGHT_PURPLE),
    LEGENDARY(GOLD),
    ARTEFACT(RED),
    WONDERFUL(GREEN);

    private final Style style;

    Rarity(TextColor color) {
        this.style = Style.style().color(color).decoration(TextDecoration.ITALIC, false).build();
    }

    public Style getStyle() {
        return style;
    }
}
