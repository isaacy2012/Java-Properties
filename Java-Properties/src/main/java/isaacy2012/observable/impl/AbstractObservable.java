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
 */
public abstract class AbstractObservable<T> implements Observable<T> {
    /**
     * Apply an update
     * @param mut the mutating function
     * @param <R> the type paramater of the mutating function (e.g .pop()) on a stack
     * @return the result from the mutation function
     */
    public abstract <R> R applyUpdate(@NotNull Function<T, R> mut);

    /**
     * Post update.
     */
    protected abstract void postUpdate();

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

    @Override
    public void observe(@NotNull Observer<T> observer) {
        observers.get().add(observer);
    }

}
