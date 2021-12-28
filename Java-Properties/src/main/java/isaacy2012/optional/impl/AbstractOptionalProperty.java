package isaacy2012.optional.impl;

import isaacy2012.optional.OptionalProperty;
import isaacy2012.property.Property;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class AbstractOptionalProperty<T, P extends Property<T>> implements OptionalProperty<T> {
    /**
     * The Prop.
     */
    protected final P prop;

    /**
     * Instantiates a new Abstract Optional Property
     *
     * @param prop the property that this Abstract Optional Property is derived from
     */
    public AbstractOptionalProperty(@NotNull P prop) {
        this.prop = prop;
    }

    @Override
    public Optional<T> get() {
        return Optional.ofNullable(prop.get());
    }
}
