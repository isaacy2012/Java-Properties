package isaacy2012.lazy;

import isaacy2012.lazy.impl.ImmutableLazyProperty;
import isaacy2012.property.Property;

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
     * @param supplier the supplier
     * @return the property
     */
    static <T> Lazy<T> of(Supplier<T> supplier) {
        return new ImmutableLazyProperty<>(supplier);
    }

}
