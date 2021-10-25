package isaacy2012.observer.impl;

import isaacy2012.observer.Observable;
import isaacy2012.observer.Observer;
import isaacy2012.property.MutableProperty;
import isaacy2012.property.Property;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

/**
 * The type Immutable observable.
 *
 * @param <T> the type parameter
 */
public class ImmutableObservable<T> extends AbstractObservable<T> {
    /**
     * The Prop.
     */
    private final Property<T> prop;

    /**
     * Instantiates a new Immutable observable.
     *
     * @param prop the prop
     */
    public ImmutableObservable(@NotNull Property<T> prop) {
        super();
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


}
