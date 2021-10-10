package isaacy2012.property.impl;

import java.util.function.Supplier;

public class ImmutableDelegateProperty<T> extends AbstractDelegateProperty<T> {
    /**
     * Instantiates a new Delegate property.
     *
     * @param getter the getter
     */
    ImmutableDelegateProperty(Supplier<T> getter) {
        super(getter);
    }
}
