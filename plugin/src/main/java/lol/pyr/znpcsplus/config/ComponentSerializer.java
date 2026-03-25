package lol.pyr.znpcsplus.config;

import io.github.blackbaroness.znpcplusmodern.MiniMessageProvider;
import net.kyori.adventure.text.Component;
import space.arim.dazzleconf.error.BadValueException;
import space.arim.dazzleconf.serialiser.Decomposer;
import space.arim.dazzleconf.serialiser.FlexibleType;
import space.arim.dazzleconf.serialiser.ValueSerialiser;

public class ComponentSerializer implements ValueSerialiser<Component> {
    @Override
    public Class<Component> getTargetClass() {
        return Component.class;
    }

    @Override
    public Component deserialise(FlexibleType flexibleType) throws BadValueException {
        return MiniMessageProvider.get().deserialize(flexibleType.getString());
    }

    @Override
    public Object serialise(Component value, Decomposer decomposer) {
        return MiniMessageProvider.get().serialize(value);
    }
}
