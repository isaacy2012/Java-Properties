package isaacy2012.property.impl;

import isaacy2012.property.MutableProperty;

import java.util.function.Function;

public class MutablePropDelegateProperty<T> implements MutableProperty<T> {
    private final MutableProperty<T> _property;
    private final Function<T, T> setter;
    private final Function<T, T> getter;

    /**
     * Instantiates a new Delegate property.
     *
     * @param property  the property
     * @param getter the getter
     * @param setter the setter
     */
    MutablePropDelegateProperty(MutableProperty<T> property, Function<T, T> getter, Function<T, T> setter) {
        this._property = property;
        this.getter = getter;
        this.setter = setter;
    }

    @Override
    public void set(T t) {
        this._property.set(setter.apply(t));
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
