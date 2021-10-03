package isaacy2012.property.impl;

import isaacy2012.property.Property;

import java.util.function.Function;

public class ImmutableValueProperty<T> implements Property<T> {
    private final T value;
    private final Function<T, T> getter;


    /**
     * Instantiates a new Delegate property.
     *
     * @param value  the value
     * @param getter the getter
     */
    ImmutableValueProperty(T value, Function<T, T> getter) {
        this.value = value;
        this.getter = getter;
    }

    @Override
    public T get() {
        return getter.apply(value);
    }

    @Override
    public String toString() {
        if (value == get()) {
            return value.toString();
        } else {
            return value + " -> " + get().toString();
        }
    }
}
