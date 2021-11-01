package isaacy2012.property.impl;

import isaacy2012.property.Property;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

/**
 * The type Value property builder.
 *
 * @param <T> the type parameter
 */
public class PropDelegatePropertyBuilder<T> extends AbstractPropDelegatePropertyBuilder<T, Property<T>> {
    /**
     * Instantiates a new Value property builder.
     *
     * @param prop the property
     */
    public PropDelegatePropertyBuilder(@NotNull Property<T> prop) {
        super(prop);
    }

    /**
     * With getter value property builder.
     *
     * @param getter the getter
     * @return the value property builder
     */
    public PropDelegatePropertyBuilder<T> withGetter(@NotNull Function<T, T> getter) {
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
