package isaacy2012.property.impl;

import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ImmutableDelegateProperty<T> extends AbstractDelegateProperty<T> {
    /**
     * Instantiates a new Delegate property.
     *
     * @param getter the getter
     */
    ImmutableDelegateProperty(@NotNull Supplier<T> getter) {
        super(getter);
    }
}
