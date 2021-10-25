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
public class MutableObservable<T> extends AbstractObservable<T> implements MutableProperty<T> {
    /**
     * The Prop.
     */
    private final MutableProperty<T> prop;

    /**
     * Instantiates a new Immutable observable.
     *
     * @param prop the prop
     */
    public MutableObservable(@NotNull MutableProperty<T> prop) {
        this.prop = prop;
    }

    @Override
    public T get() {
        return prop.get();
    }

    /**
     * Post update.
     */
    @Override
    protected void postUpdate() {
        observers.get().forEach(it -> it.callback(this.prop.get()));
    }

    /**
     * Mutate r.
     *
     * @param <R> the type parameter
     * @param mut the mut
     * @return the r
     */
    public <R> R applyUpdate(@NotNull Function<T, R> mut) {
        R ret = mut.apply(this.prop.get());
        postUpdate();
        return ret;
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
