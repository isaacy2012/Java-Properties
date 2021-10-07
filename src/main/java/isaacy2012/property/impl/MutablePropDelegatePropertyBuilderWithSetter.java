package isaacy2012.property.impl;

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
            MutablePropDelegatePropertyBuilder<T> builder,
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
    public MutablePropDelegateProperty<T> build() {
        return new MutablePropDelegateProperty<>(builder._property,
                builder.getter != null ? builder.getter : Function.identity(),
                this.setter != null ? this.setter : Function.identity()
        );
    }
}
