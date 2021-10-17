package isaacy2012.property.impl;

import isaacy2012.property.Property;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

/**
 * A Prop Delegate Property that is immutable.
 *
 * @param <T> the type parameter
 */
public class ImmutablePropDelegateProperty<T> implements Property<T> {
    /**
     * The Property.
     */
    private final Property<T> _property;
    /**
     * The Getter.
     */
    private final Function<T, T> getter;


    /**
     * Instantiates a new Delegate property.
     *
     * @param property the property
     * @param getter   the getter
     */
    ImmutablePropDelegateProperty(Property<T> property, @NotNull Function<T, T> getter) {
        _property = property;
        this.getter = getter;
    }

    @Override
    public T get() {
        return getter.apply(_property.get());
    }

    @Override
    public String toString() {
        if (get() == _property.get()) {
            return get().toString();
        } else {
            return _property.get() + " -> " + get().toString();
        }
    }
}
