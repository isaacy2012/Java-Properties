package isaacy2012.property;

/**
 * The interface Value property.
 *
 * @param <T> the type parameter
 */
public interface ValueProperty<T> extends Property<T> {
    /**
     * Init.
     *
     * @param t the t
     */
    void init(T t);
}
