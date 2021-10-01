package isaacy2012.property;

import isaacy2012.property.impl.DelegatePropertyBuilder;
import isaacy2012.property.impl.ValuePropertyBuilder;

import java.util.function.Supplier;

/**
 * Storing a property in this Property automatically gives it a getter.
 * This reduces the need for a getter in the class that has the Property as a field, since
 * it can be final.
 * prop.get();
 *
 * @param <T> the type parameter
 * @author Isaac Young youngisaa/isaacy2012
 */
public interface Property<T> {
    /**
     * Get t.
     *
     * @return the t
     */
    T get();

    /**
     * Instantiates a new Property builder.
     *
     * @param <T>    the type parameter
     * @param getter the getter
     * @return the delegate property builder
     */
    static <T> DelegatePropertyBuilder<T> of(Supplier<T> getter) {
        return new DelegatePropertyBuilder<>(getter);
    }

    /**
     * Instantiates a new Property builder.
     *
     * @param <T>   the type parameter
     * @param value the value
     * @return the delegate property builder
     */
    static <T> ValuePropertyBuilder<T> of(T value) {
        return new ValuePropertyBuilder<>(value);
    }
}

