package isaacy2012.lazy.impl;

import isaacy2012.lazy.Lazy;
import isaacy2012.property.Property;
import isaacy2012.property.ValueProperty;

import java.util.function.Supplier;

public abstract class AbstractLazyProperty<T, K extends ValueProperty<T>> implements Lazy<T> {
    K prop;
    Supplier<T> supplier;

    public AbstractLazyProperty(Supplier<T> supplier, K prop) {
        this.prop = prop;
        this.supplier = supplier;
    }

    @Override
    public T get() {
        if (prop.get() == null) {
            prop.init(supplier.get());
        }
        return prop.get();
    }
}
