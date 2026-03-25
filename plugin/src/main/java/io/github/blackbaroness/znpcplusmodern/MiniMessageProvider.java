package io.github.blackbaroness.znpcplusmodern;

import lombok.experimental.UtilityClass;
import net.kyori.adventure.text.minimessage.MiniMessage;

@UtilityClass
public class MiniMessageProvider {
    public static MiniMessage get() {
        throw new RuntimeException("This should be replaced in different module");
    }
}
