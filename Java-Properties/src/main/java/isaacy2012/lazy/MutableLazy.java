package isaacy2012.lazy;

import isaacy2012.lazy.impl.ImmutableLazyProperty;
import isaacy2012.lazy.impl.MutableLazyProperty;
import isaacy2012.property.MutableProperty;
import isaacy2012.property.Property;

import java.util.function.Supplier;

/**
 * The interface Lazy.
 *
 * @param <T> the type parameter
 */
public interface MutableLazy<T> extends Lazy<T>, MutableProperty<T> {
    /**
     * Of property.
     *
     * @param <T>      the type parameter
     * @param supplier the supplier
     * @return the property
     */
    static <T> MutableLazy<T> of(Supplier<T> supplier) {
        return new MutableLazyProperty<T>(supplier);
    }

}
