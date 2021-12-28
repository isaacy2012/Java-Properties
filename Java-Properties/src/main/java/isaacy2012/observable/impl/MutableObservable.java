package isaacy2012.observable.impl;

import isaacy2012.observable.Observer;
import isaacy2012.property.MutableProperty;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

/**
 * The type Immutable observable.
 *
 * @param <T> the type parameter
 */
public class MutableObservable<T> extends AbstractObservable<T, MutableProperty<T>> implements MutableProperty<T> {

    /**
     * Instantiates a new Mutable observable.
     *
     * @param prop the prop
     */
    public MutableObservable(@NotNull MutableProperty<T> prop) {
        super(prop);
    }

    @Override
    public void set(T value) {
        prop.set(value);
        postUpdate();
    }

    @Override
    public void observe(@NotNull Observer<T> observer) {
        observers.get().add(observer);
    }

}
