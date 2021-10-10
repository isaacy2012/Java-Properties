package isaacy2012.property.impl;

import isaacy2012.property.MutableProperty;

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
    public MutablePropDelegatePropertyBuilder<T> withGetter(Function<T, T> getter) {
        this.getter = getter;

        return this;
    }

    /**
     * With setter mutable prop delegate property builder with setter.
     *
     * @param setter the setter
     * @return the property
     */
    public MutablePropDelegatePropertyBuilderWithSetter<T> withSetter(Function<T, T> setter) {
        return new MutablePropDelegatePropertyBuilderWithSetter<>(this, setter);
    }
}
