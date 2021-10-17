package isaacy2012.property.impl;

import isaacy2012.property.MutableProperty;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

/**
 * The type Delegate property builder.
 *
 * @param <T> the type parameter
 */
public class MutableDelegatePropertyBuilderWithSetter<T> {
    private final MutableDelegatePropertyBuilder<T> builder;
    /**
     * The Getter.
     */
    Consumer<T> setter;

    /**
     * Instantiates a new Delegate property builder.
     *
     * @param builder the builder
     * @param setter  the setter
     */
    public MutableDelegatePropertyBuilderWithSetter(@NotNull MutableDelegatePropertyBuilder<T> builder,
                                                    @NotNull Consumer<T> setter) {

        this.builder = builder;
        this.setter = setter;
    }


    /**
     * Build property.
     *
     * @return the property
     */
    public MutableProperty<T> build() {
        return new MutableDelegateProperty<>(builder.getter, setter);
    }
}
