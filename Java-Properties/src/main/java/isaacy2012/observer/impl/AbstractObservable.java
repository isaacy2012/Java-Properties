package isaacy2012.observer.impl;

import isaacy2012.observer.Observable;
import isaacy2012.observer.Observer;
import isaacy2012.property.Property;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

/**
 * The type Abstract observable.
 *
 * @param <T> the type parameter
 */
public abstract class AbstractObservable<T> implements Observable<T> {
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

    public abstract <R> R applyUpdate(Function<T, R> mut);

    /**
     * Post update.
     */
    protected abstract void postUpdate();

    @Override
    public void observe(Observer<T> observer) {
        observers.get().add(observer);
    }

}
