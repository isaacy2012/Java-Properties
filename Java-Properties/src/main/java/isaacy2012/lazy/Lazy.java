package isaacy2012.lazy;

import isaacy2012.lazy.impl.ImmutableLazyProperty;
import isaacy2012.lazy.impl.MutableLazyProperty;
import isaacy2012.property.MutableProperty;
import isaacy2012.property.Property;
import isaacy2012.property.impl.ImmutableValueProperty;
import isaacy2012.property.impl.MutableValueProperty;

import java.util.function.Supplier;

/**
 * The interface Lazy.
 *
 * @param <T> the type parameter
 */
public interface Lazy<T> extends Property<T> {
    /**
     * Of property.
     *
     * @param <T>      the type parameter
     * @param prop     the prop
     * @param supplier the supplier
     * @return the property
     */
    static <T> Property<T> of(ImmutableValueProperty<T> prop, Supplier<T> supplier) {
        return new ImmutableLazyProperty<>(prop, supplier);
    }

    /**
     * Of mutable property.
     *
     * @param <T>      the type parameter
     * @param prop     the prop
     * @param supplier the supplier
     * @return the mutable property
     */
    static <T> MutableProperty<T> of(MutableValueProperty<T> prop, Supplier<T> supplier) {
        return new MutableLazyProperty<>(prop, supplier);
    }
}
