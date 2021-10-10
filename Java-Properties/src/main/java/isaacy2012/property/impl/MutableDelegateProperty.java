package isaacy2012.property.impl;

import isaacy2012.property.MutableProperty;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * The type Mutable delegate property.
 *
 * @param <T> the type parameter
 */
public class MutableDelegateProperty<T> extends AbstractDelegateProperty<T> implements MutableProperty<T> {

    /**
     * The Setter.
     */
    private final Consumer<T> setter;

    /**
     * Instantiates a new Mutable delegate property.
     *
     * @param getter the getter
     * @param setter the setter
     */
    MutableDelegateProperty(Supplier<T> getter, Consumer<T> setter) {
        super(getter);
        this.setter = setter;
    }

    @Override
    public void set(T t) {
        setter.accept(t);
    }
}
