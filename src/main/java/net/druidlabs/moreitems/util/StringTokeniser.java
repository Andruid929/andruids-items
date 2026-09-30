package net.druidlabs.moreitems.util;

import org.jetbrains.annotations.NotNull;

public final class StringTokeniser {

    public static String @NotNull [] getKeys(@NotNull String keyString) {
        String bracketLess = keyString.substring(1, keyString.length() - 1).replaceAll("\\s+", "");

        return bracketLess.split(",");
    }

}
