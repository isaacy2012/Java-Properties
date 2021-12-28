package isaacy2012.optional;

import isaacy2012.optional.impl.ImmutableOptionalProperty;
import isaacy2012.optional.impl.MutableOptionalProperty;
import isaacy2012.property.MutableProperty;
import isaacy2012.property.Property;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public interface OptionalProperty<T> extends Property<Optional<T>> {
    static <T> OptionalProperty<T> of(@NotNull Property<T> prop) {
        return new ImmutableOptionalProperty(prop);
    }

    static <T> MutableOptionalProperty<T> of(@NotNull MutableProperty<T> prop) {
        return new MutableOptionalProperty(prop);
    }
}
