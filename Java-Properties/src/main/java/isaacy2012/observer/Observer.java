package isaacy2012.observer;

import isaacy2012.observer.impl.MutableObservable;
import isaacy2012.property.MutableProperty;

/**
 * The interface Observer.
 *
 * @param <T> the type parameter
 */
public interface Observer<T> {
    /**
     * Callback.
     *
     * @param obj the obj
     */
    void callback(T obj);

}
