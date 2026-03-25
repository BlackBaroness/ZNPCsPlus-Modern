package io.github.blackbaroness.znpcplusmodern;

import lombok.experimental.UtilityClass;
import net.kyori.adventure.text.minimessage.MiniMessage;

@SuppressWarnings("unused")
@UtilityClass
public class MiniMessageProvider {
    public static MiniMessage get() {
        return MiniMessage.get();
    }
}
