package isaacy2012.lazy.impl;

import isaacy2012.lazy.Lazy;
import isaacy2012.property.ValueProperty;

import java.util.function.Supplier;

public abstract class AbstractLazyProperty<T> implements Lazy<T> {
    final Supplier<T> supplier;
    T obj = null;

    /**
     * Instantiates a new Abstract lazy property.
     *
     * @param supplier the supplier
     */
    public AbstractLazyProperty(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    @Override
    public T get() {
        if (obj == null) {
            obj = supplier.get();
        }
        return obj;
    }

}
