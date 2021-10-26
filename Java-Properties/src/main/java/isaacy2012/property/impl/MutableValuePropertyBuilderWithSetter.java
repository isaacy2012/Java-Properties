package isaacy2012.property.impl;

import isaacy2012.property.MutableProperty;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class MutableValuePropertyBuilderWithSetter<T> {
    private final MutableValuePropertyBuilder<T> builder;
    private final Function<T, T> setter;

    /**
     * Instantiates a new Mutable value property builder.
     *
     * @param builder the builder
     * @param setter  the setter
     */
    public MutableValuePropertyBuilderWithSetter(
            @NotNull MutableValuePropertyBuilder<T> builder,
            @NotNull Function<T, T> setter
    ) {
        this.builder = builder;
        this.setter = setter;
    }

    /**
     * Build mutable property.
     *
     * @return the mutable property
     */
    public MutableValueProperty<T> build() {
        return new MutableValueProperty<>(
                builder.value,
                builder.getter,
                this.setter
        );
    }
}
