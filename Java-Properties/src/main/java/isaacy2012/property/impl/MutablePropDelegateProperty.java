package isaacy2012.property.impl;

import isaacy2012.property.MutableProperty;

import java.util.function.Function;

/**
 * A Prop Delegate Property that is mutable.
 * Note that since it is mutable, it requires that its underlying property
 * is itself a MutableProperty.
 *
 * @param <T> the type parameter
 */
public class MutablePropDelegateProperty<T> implements MutableProperty<T> {
    /**
     * The Property.
     */
    private final MutableProperty<T> _property;
    /**
     * The Setter.
     */
    private final Function<T, T> setter;
    /**
     * The Getter.
     */
    private final Function<T, T> getter;

    /**
     * Instantiates a new Delegate property.
     *
     * @param property the property
     * @param getter   the getter
     * @param setter   the setter
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
