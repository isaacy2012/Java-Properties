package isaacy2012.observable.impl;

import isaacy2012.observable.Observable;
import isaacy2012.observable.Observer;
import isaacy2012.property.Property;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

/**
 * The type Abstract observable.
 *
 * @param <T> the type parameter
 * @param <P> the type parameter
 */
public abstract class AbstractObservable<T, P extends Property<T>> implements Observable<T> {
    /**
     * The Prop.
     */
    protected final P prop;

    /**
     * The Listeners.
     */
    private Set<Observer<T>> _observers = null;

    /**
     * The Observers.
     */
    protected final Property<Set<Observer<T>>> observers = () -> {
        if (_observers == null) {
            _observers = new HashSet<>();
        }
        return _observers;
    };

    /**
     * Instantiates a new Abstract observable.
     *
     * @param prop the prop
     */
    public AbstractObservable(@NotNull P prop) {
        this.prop = prop;
    }


    @Override
    public T get() {
        return prop.get();
    }

    /**
     * Post update.
     */
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
    public void observe(@NotNull Observer<T> observer) {
        observers.get().add(observer);
    }

}
