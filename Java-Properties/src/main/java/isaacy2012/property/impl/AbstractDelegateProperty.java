package isaacy2012.property.impl;

import isaacy2012.property.Property;

import java.util.function.Supplier;

/**
 * A Delegate Property delegates the 'get()' to a getter.
 * Thus, no value is stored in the property.
 *
 * @param <T> the type parameter
 */
public abstract class AbstractDelegateProperty<T> implements Property<T> {
    private final Supplier<T> getter;


    /**
     * Instantiates a new Abstract delegate property.
     *
     * @param getter the getter
     */
    AbstractDelegateProperty(Supplier<T> getter) {
        this.getter = getter;
    }

    @Override
    public T get() {
        return getter.get();
    }

    @Override
    public String toString() {
        return getter.get().toString();
    }
}
