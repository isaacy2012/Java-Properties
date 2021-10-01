package isaacy2012.property.impl;

import isaacy2012.property.MutableProperty;

import java.util.function.Function;

/**
 * The type Mutable value property builder.
 *
 * @param <T> the type parameter
 */
public class MutableValuePropertyBuilder<T> extends ValuePropertyBuilder<T> {

    /**
     * Instantiates a new Mutable value property builder.
     *
     * @param value the value
     */
    public MutableValuePropertyBuilder(T value) {
        super(value);
    }

    /**
     * With getter value property builder.
     *
     * @param getter the getter
     * @return the value property builder
     */
    public MutableValuePropertyBuilder<T> withGetter(Function<T, T> getter) {
        this.getter = getter;

        return this;
    }

    /**
     * With setter mutable delegate property builder with setter.
     *
     * @param setter the setter
     * @return the mutable delegate property builder with setter
     */
    public MutableValuePropertyBuilderWithSetter<T> withSetter(Function<T, T> setter) {
        return new MutableValuePropertyBuilderWithSetter<>(this, setter);
    }

    @Override
    public MutableProperty<T> build() {
        return new MutableValueProperty<>(value,
                getter != null ? getter : (t) -> t,
                (t) -> t);
    }
}
