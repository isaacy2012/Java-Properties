package isaacy2012.lazy.impl;

import isaacy2012.lazy.MutableLazy;
import isaacy2012.property.MutableProperty;
import isaacy2012.property.ValueProperty;
import isaacy2012.property.impl.MutableValueProperty;

import java.util.function.Supplier;

public class MutableLazyProperty<T> extends AbstractLazyProperty<T> implements MutableLazy<T> {
    /**
     * Instantiates a new Abstract lazy property.
     *
     * @param supplier the supplier
     */
    public MutableLazyProperty(Supplier<T> supplier) {
        super(supplier);
    }


    @Override
    public void set(T value) {
        obj = value;
    }
}
