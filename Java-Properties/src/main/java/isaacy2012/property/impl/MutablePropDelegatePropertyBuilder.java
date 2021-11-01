package isaacy2012.property.impl;

import isaacy2012.property.MutableProperty;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

/**
 * The type Value property builder.
 *
 * @param <T> the type parameter
 */
public class MutablePropDelegatePropertyBuilder<T> {
    /**
     * The Value.
     */
    MutableProperty<T> _property;

    /**
     * The Getter.
     */
    Function<T, T> getter;
    /**
     * The Setter.
     */
    Function<T, T> setter;

    /**
     * Instantiates a new Value property builder.
     *
     * @param prop the property
     */
    public MutablePropDelegatePropertyBuilder(MutableProperty<T> prop) {
        this._property = prop;
    }

    /**
     * With getter value property builder.
     *
     * @param getter the getter
     * @return the value property builder
     */
    public MutablePropDelegatePropertyBuilder<T> withGetter(@NotNull Function<T, T> getter) {
        this.getter = getter;

        return this;
    }

    /**
     * With setter mutable prop delegate property builder with setter.
     *
     * @param setter the setter
     * @return the property
     */
    public MutablePropDelegatePropertyBuilder<T> withSetter(@NotNull Function<T, T> setter) {
        this.setter = setter;

        return this;
    }

    /**
     * Build mutable prop delegate property.
     *
     * @return the mutable prop delegate property
     */
    public MutablePropDelegateProperty<T> build() {
        return new MutablePropDelegateProperty<>(_property,
                getter != null ? getter : Function.identity(),
                setter != null ? setter : Function.identity()
        );
    }
}
