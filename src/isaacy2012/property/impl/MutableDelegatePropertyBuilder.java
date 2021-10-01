package isaacy2012.property.impl;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * The type Delegate property builder.
 *
 * @param <T> the type parameter
 */
public class MutableDelegatePropertyBuilder<T> {
    /**
     * The Getter.
     */
    Supplier<T> getter;

    /**
     * Instantiates a new Delegate property builder.
     *
     * @param getter the getter
     */
    public MutableDelegatePropertyBuilder(Supplier<T> getter) {
        this.getter = getter;
    }

    /**
     * With setter mutable delegate property builder with setter.
     *
     * @param setter the setter
     * @return the mutable delegate property builder with setter
     */
    public MutableDelegatePropertyBuilderWithSetter<T> withSetter(
    Consumer<T> setter) {
        return new MutableDelegatePropertyBuilderWithSetter<>(this, setter);
    }

}
