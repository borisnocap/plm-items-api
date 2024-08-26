package ru.plm.items;

import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;

import static net.kyori.adventure.text.format.NamedTextColor.*;

@SuppressWarnings("unused")
public enum Rarity {
    COMMON(WHITE),
    UNCOMMON(YELLOW),
    RARE(AQUA),
    EPIC(LIGHT_PURPLE),
    LEGENDARY(GOLD),
    ARTEFACT(RED);

    private final TextColor color;
    private final Style nonItalicColor;

    Rarity(TextColor color) {
        this.color = color;
        nonItalicColor = Style.style(color).decoration(TextDecoration.ITALIC, false);
    }

    public TextColor getColor() {
        return color;
    }

    public Style getNonItalicColor() {
        return nonItalicColor;
    }
}
