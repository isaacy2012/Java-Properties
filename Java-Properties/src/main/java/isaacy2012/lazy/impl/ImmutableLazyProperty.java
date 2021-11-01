package isaacy2012.lazy.impl;

import isaacy2012.property.Property;
import isaacy2012.property.ValueProperty;
import isaacy2012.property.impl.ImmutableValueProperty;

import java.util.function.Supplier;

public class ImmutableLazyProperty<T> extends AbstractLazyProperty<T> {

    /**
     * Instantiates a new Immutable lazy property.
     *
     * @param supplier the supplier
     */
    public ImmutableLazyProperty(Supplier<T> supplier) {
        super(supplier);
    }

}
