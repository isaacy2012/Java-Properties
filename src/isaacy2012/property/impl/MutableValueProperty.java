package isaacy2012.property.impl;

import isaacy2012.property.MutableProperty;

import java.util.function.Function;

public class MutableValueProperty<T> implements MutableProperty<T> {
    private T value;
    private final Function<T, T> setter;
    private final Function<T, T> getter;

    /**
     * Instantiates a new Delegate property.
     *
     * @param value  the value
     * @param getter the getter
     * @param setter the setter
     */
    MutableValueProperty(T value, Function<T, T> getter, Function<T, T> setter) {
        this.value = value;
        this.getter = getter;
        this.setter = setter;
    }

    @Override
    public void set(T t) {
        this.value = setter.apply(t);
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
