package isaacy2012.property.impl;

import isaacy2012.property.Property;

import java.util.function.Function;

/**
 * The type Value property builder.
 *
 * @param <T> the type parameter
 */
public class PropDelegatePropertyBuilder<T> {
    /**
     * The Value.
     */
    Property<T> _property;

    /**
     * The Getter.
     */
    Function<T, T> getter;

    /**
     * Instantiates a new Value property builder.
     *
     * @param prop the property
     */
    public PropDelegatePropertyBuilder(Property<T> prop) {
        this._property = prop;
    }

    /**
     * With getter value property builder.
     *
     * @param getter the getter
     * @return the value property builder
     */
    public PropDelegatePropertyBuilder<T> withGetter(Function<T, T> getter) {
        this.getter = getter;

        return this;
    }

    /**
     * Build property.
     *
     * @return the property
     */
    public ImmutablePropDelegateProperty<T> build() {
        return new ImmutablePropDelegateProperty<>(_property, getter != null ? getter : Function.identity());
    }
}
