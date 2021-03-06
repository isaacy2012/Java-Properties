package isaacy2012.property.impl;

import isaacy2012.property.Property;
import org.jetbrains.annotations.NotNull;

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
    private final Supplier<T> getter;

    /**
     * Instantiates a new Delegate property builder.
     *
     * @param getter the getter
     */
    public DelegatePropertyBuilder(@NotNull Supplier<T> getter) {
        this.getter = getter;
    }

    /**
     * Build property.
     *
     * @return the property
     */
    public Property<T> build() {
        return new ImmutableDelegateProperty<>(getter);
    }
}
