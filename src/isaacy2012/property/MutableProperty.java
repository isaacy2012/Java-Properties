package isaacy2012.property;

import isaacy2012.property.impl.MutableDelegatePropertyBuilder;
import isaacy2012.property.impl.MutableValuePropertyBuilder;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface MutableProperty<T> extends Property<T> {
    /**
     * Set.
     *
     * @param value the value
     */
    void set(T value);

    /**
     * Instantiates a new Property builder.
     *
     * @param <T>    the type parameter
     * @param getter the getter
     * @return the delegate property builder
     */
    static <T> MutableDelegatePropertyBuilder<T> withGetter(Supplier<T> getter) {
        return new MutableDelegatePropertyBuilder<>(getter);
    }

    /**
     * Of mutable property.
     *
     * @param <T>   the type parameter
     * @param value the value
     * @return the mutable property
     */
    static <T> MutableProperty<T> of(T value) {
        return withValue(value).build();
    }

    /**
     * Instantiates a new Property builder.
     *
     * @param <T>   the type parameter
     * @param value the value
     * @return the delegate property builder
     */
    static <T> MutableValuePropertyBuilder<T> withValue(T value) {
        return new MutableValuePropertyBuilder<>(value);
    }
}
