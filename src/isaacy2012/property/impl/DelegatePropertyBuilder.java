package isaacy2012.property.impl;

import isaacy2012.property.Property;
import isaacy2012.property.impl.DelegateProperty;

import java.util.function.Supplier;

/**
 * The type Delegate property builder.
 *
 * @param <T> the type parameter
 */
public class DelegatePropertyBuilder<T> {
    /**
     * The Getter.
     */
    Supplier<T> getter;

    /**
     * Instantiates a new Delegate property builder.
     *
     * @param getter the getter
     */
    public DelegatePropertyBuilder(Supplier<T> getter) {
        this.getter = getter;
    }

    /**
     * Build property.
     *
     * @return the property
     */
    public Property<T> build() {
        return new DelegateProperty<>(getter);
    }
}
