package isaacy2012.property.impl;

import isaacy2012.property.exception.PropertyAlreadyInitializedException;
import isaacy2012.property.exception.PropertyNotInitializedException;
import isaacy2012.property.ValueProperty;

import java.util.function.Function;

public class ImmutableValueProperty<T> implements ValueProperty<T> {
    private T value;
    private final Function<T, T> getter;
    private boolean initialized;


    /**
     * Instantiates a new Delegate property.
     *
     * @param value       the value
     * @param getter      the getter
     * @param initialized the initialized
     */
    ImmutableValueProperty(T value, Function<T, T> getter, boolean initialized) {
        this.value = value;
        this.getter = getter;
        this.initialized = initialized;
    }

    @Override
    public void init(T t) {
        if (initialized) {
            throw new PropertyAlreadyInitializedException("Property has already been initialized!");
        }
        this.value = t;
        initialized = true;
    }

    @Override
    public T get() {
        if (!initialized) {
            throw new PropertyNotInitializedException("Property has already been initialized!");
        }
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
