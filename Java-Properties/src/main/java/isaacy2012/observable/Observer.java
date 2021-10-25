package isaacy2012.observable;

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
