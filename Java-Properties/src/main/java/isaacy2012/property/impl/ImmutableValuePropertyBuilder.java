package isaacy2012.property.impl;

import java.util.function.Function;

/**
 * The type Value property builder.
 *
 * @param <T> the type parameter
 */
public class ImmutableValuePropertyBuilder<T> {
    /**
     * The Value.
     */
    T value;

    /**
     * The Getter.
     */
    Function<T, T> getter;

    /**
     * With getter value property builder.
     *
     * @param getter the getter
     * @return the value property builder
     */
    public ImmutableValuePropertyBuilder<T> withGetter(Function<T, T> getter) {
        this.getter = getter;

        return this;
    }

    /**
     * Build property.
     *
     * @return the property
     */
    public ImmutableValueProperty<T> build() {
        return new ImmutableValueProperty<>(null, getter != null ? getter : Function.identity(), false);
    }
}
