package isaacy2012.property.impl;

import isaacy2012.property.MutableProperty;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

/**
 * The type Mutable value property builder.
 *
 * @param <T> the type parameter
 */
public class MutableValuePropertyBuilder<T> extends ValuePropertyBuilder<T> {
    /**
     * The Setter.
     */
    Function<T, T> setter;

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
    public MutableValuePropertyBuilder<T> withGetter(@NotNull Function<T, T> getter) {
        this.getter = getter;

        return this;
    }

    /**
     * With setter mutable delegate property builder with setter.
     *
     * @param setter the setter
     * @return the mutable delegate property builder with setter
     */
    public MutableValuePropertyBuilder<T> withSetter(@NotNull Function<T, T> setter) {
        this.setter = setter;

        return this;
    }

    @Override
    public MutableValueProperty<T> build() {
        return new MutableValueProperty<>(value,
                getter != null ? getter : Function.identity(),
                setter != null ? setter : Function.identity()
        );
    }
}
