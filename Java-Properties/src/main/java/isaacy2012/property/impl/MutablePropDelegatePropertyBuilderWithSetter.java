package isaacy2012.property.impl;

import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class MutablePropDelegatePropertyBuilderWithSetter<T> {
    private final MutablePropDelegatePropertyBuilder<T> builder;
    private final Function<T, T> setter;

    /**
     * Instantiates a new Mutable value property builder.
     *
     * @param builder the builder
     * @param setter  the setter
     */
    public MutablePropDelegatePropertyBuilderWithSetter(
            @NotNull MutablePropDelegatePropertyBuilder<T> builder,
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
    public MutablePropDelegateProperty<T> build() {
        return new MutablePropDelegateProperty<>(
                builder._property,
                builder.getter,
                this.setter
        );
    }
}
