package isaacy2012.property.impl;

import isaacy2012.property.Property;

import java.util.function.Supplier;

public class DelegateProperty<T> implements Property<T> {
    Supplier<T> getter;


    /**
     * Instantiates a new Delegate property.
     *
     * @param getter the getter
     */
    public DelegateProperty(Supplier<T> getter) {
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
