package isaacy2012.property.impl;

import isaacy2012.property.Property;

import java.util.function.Function;

public class ImmutablePropDelegateProperty<T> implements Property<T> {
    private final Property<T> _property;
    private final Function<T, T> getter;


    /**
     * Instantiates a new Delegate property.
     *
     * @param property the property
     * @param getter   the getter
     */
    ImmutablePropDelegateProperty(Property<T> property, Function<T, T> getter) {
        _property = property;
        this.getter = getter;
    }

    @Override
    public T get() {
        return getter.apply(_property.get());
    }

    @Override
    public String toString() {
        return get().toString();
    }
}
