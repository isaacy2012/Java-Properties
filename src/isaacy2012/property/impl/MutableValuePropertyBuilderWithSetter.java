package isaacy2012.property.impl;

import isaacy2012.property.MutableProperty;

import java.util.function.Function;

public class MutableValuePropertyBuilderWithSetter<T> {
    MutableValuePropertyBuilder<T> builder;
    Function<T, T> setter;

    /**
     * Instantiates a new Mutable value property builder.
     *
     * @param builder the builder
     * @param setter  the setter
     */
    public MutableValuePropertyBuilderWithSetter(
            MutableValuePropertyBuilder<T> builder,
            Function<T, T> setter
    ) {
        this.builder = builder;
        this.setter = setter;
    }

    /**
     * Build mutable property.
     *
     * @return the mutable property
     */
    public MutableProperty<T> build() {
        return new MutableValueProperty<>(builder.value,
                builder.getter != null ? builder.getter : (t) -> t,
                this.setter != null ? this.setter : (t) -> t
        );
    }
}
