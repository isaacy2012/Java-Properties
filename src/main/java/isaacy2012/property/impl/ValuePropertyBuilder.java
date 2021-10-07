package isaacy2012.property.impl;

import isaacy2012.property.Property;

import java.util.function.Function;

/**
 * The type Value property builder.
 *
 * @param <T> the type parameter
 */
public class ValuePropertyBuilder<T> {
    /**
     * The Value.
     */
    T value;

    /**
     * The Getter.
     */
    Function<T, T> getter;

    /**
     * Instantiates a new Value property builder.
     *
     * @param value the value
     */
    public ValuePropertyBuilder(T value) {
        this.value = value;
    }

    /**
     * With getter value property builder.
     *
     * @param getter the getter
     * @return the value property builder
     */
    public ValuePropertyBuilder<T> withGetter(Function<T, T> getter) {
        this.getter = getter;

        return this;
    }

    /**
     * Build property.
     *
     * @return the property
     */
    public Property<T> build() {
        return new ImmutableValueProperty<>(value, getter != null ? getter : Function.identity(), true);
    }
}
