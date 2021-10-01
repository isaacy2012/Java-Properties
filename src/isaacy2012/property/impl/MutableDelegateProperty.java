package isaacy2012.property.impl;

import isaacy2012.property.MutableProperty;
import isaacy2012.property.impl.DelegateProperty;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * The type Mutable delegate property.
 *
 * @param <T> the type parameter
 */
public class MutableDelegateProperty<T> extends DelegateProperty<T> implements MutableProperty<T> {

    /**
     * The Setter.
     */
    Consumer<T> setter;

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
