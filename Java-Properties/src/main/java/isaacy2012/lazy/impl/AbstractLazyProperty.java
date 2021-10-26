package isaacy2012.lazy.impl;

import isaacy2012.lazy.Lazy;
import isaacy2012.property.ValueProperty;

import java.util.function.Supplier;

public abstract class AbstractLazyProperty<T, P extends ValueProperty<T>> implements Lazy<T> {
    P prop;
    Supplier<T> supplier;
    private boolean initialized = false;

    /**
     * Instantiates a new Abstract lazy property.
     *
     * @param supplier the supplier
     * @param prop     the prop
     */
    public AbstractLazyProperty(P prop, Supplier<T> supplier) {
        this.prop = prop;
        this.supplier = supplier;
    }

    @Override
    public T get() {
        if (!initialized) {
            prop.init(supplier.get());
            initialized = true;
        }
        return prop.get();
    }
}
