package ru.plm.items;

import net.kyori.adventure.text.format.TextColor;

import static net.kyori.adventure.text.format.NamedTextColor.*;

@SuppressWarnings("unused")
public enum Rarity {
    COMMON(WHITE),
    UNCOMMON(YELLOW),
    RARE(AQUA),
    EPIC(LIGHT_PURPLE),
    LEGENDARY(GOLD),
    ARTEFACT(RED),
    WONDERFUL(GREEN);

    private final TextColor color;

    Rarity(TextColor color) {
        this.color = color;
    }

    public TextColor getColor() {
        return color;
    }
}
