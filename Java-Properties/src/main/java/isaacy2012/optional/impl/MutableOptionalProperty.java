package isaacy2012.optional.impl;

import isaacy2012.property.MutableProperty;
import isaacy2012.property.Property;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class MutableOptionalProperty<T> extends AbstractOptionalProperty<T, MutableProperty<T>> implements Property<Optional<T>> {

    /**
     * Instantiates a new Mutable Optional Property.
     *
     * @param prop the prop
     */
    public MutableOptionalProperty(@NotNull MutableProperty<T> prop) {
        super(prop);
    }

    /**
     * Set optional.
     * @param value the value
     */
    public void set(@Nullable T value) {
        this.prop.set(value);
    }

}
