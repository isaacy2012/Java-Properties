package isaacy2012.property.impl;

import isaacy2012.property.MutableProperty;

import java.util.function.Function;

public class MutableValueProperty<T> extends ValueProperty<T> implements MutableProperty<T> {
    Function<T, T> setter;

    /**
     * Instantiates a new Delegate property.
     *
     * @param value  the value
     * @param getter the getter
     * @param setter the setter
     */
    public MutableValueProperty(T value, Function<T, T> getter, Function<T, T> setter) {
        super(value, getter);
        this.setter = setter;
    }

    @Override
    public void set(T t) {
        this.value = setter.apply(t);
    }
}
