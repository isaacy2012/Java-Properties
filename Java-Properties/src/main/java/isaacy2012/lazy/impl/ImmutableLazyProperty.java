package isaacy2012.lazy.impl;

import isaacy2012.property.Property;
import isaacy2012.property.ValueProperty;
import isaacy2012.property.impl.ImmutableValueProperty;

import java.util.function.Supplier;

public class ImmutableLazyProperty<T> extends AbstractLazyProperty<T, ImmutableValueProperty<T>> {
    /**
     * Instantiates a new Immutable lazy property.
     *
     * @param supplier the supplier
     * @param prop     the prop
     */
    public ImmutableLazyProperty(ImmutableValueProperty<T> prop, Supplier<T> supplier) {
        super(prop, supplier);
    }

}
