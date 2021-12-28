package isaacy2012.optional.impl;

import isaacy2012.property.Property;
import org.jetbrains.annotations.NotNull;

public class ImmutableOptionalProperty<T> extends AbstractOptionalProperty<T, Property<T>> {

    /**
     * Instantiates a new Immutable Optional Property.
     *
     * @param prop the property this Immutable Optional Property is derived from
     */
    public ImmutableOptionalProperty(@NotNull Property<T> prop) {
        super(prop);
    }
}
