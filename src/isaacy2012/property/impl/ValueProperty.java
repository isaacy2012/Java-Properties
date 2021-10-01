package isaacy2012.property.impl;

import isaacy2012.property.Property;

import java.util.function.Function;

public class ValueProperty<T> implements Property<T> {
    T value;
    Function<T, T> getter;


    /**
     * Instantiates a new Delegate property.
     *
     * @param value  the value
     * @param getter the getter
     */
    ValueProperty(T value, Function<T, T> getter) {
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
