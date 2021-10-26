package isaacy2012.lazy.impl;

import isaacy2012.property.MutableProperty;
import isaacy2012.property.ValueProperty;
import isaacy2012.property.impl.MutableValueProperty;

import java.util.function.Supplier;

public class MutableLazyProperty<T> extends AbstractLazyProperty<T, MutableValueProperty<T>> implements MutableProperty<T> {
    /**
     * Instantiates a new Abstract lazy property.
     *
     * @param supplier the supplier
     * @param prop     the prop
     */
    public MutableLazyProperty(MutableValueProperty<T> prop, Supplier<T> supplier) {
        super(prop, supplier);
    }


    @Override
    public void set(T value) {
        prop.set(value);
    }
}
