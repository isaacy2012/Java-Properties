package isaacy2012.property;

import isaacy2012.property.exception.ValueAlreadyInitializedException;

/**
 * The interface Value property.
 *
 * @param <T> the type parameter
 */
public interface ValueProperty<T> extends Property<T> {
    /**
     * Initialize the value.
     *
     * @param value the value
     * @throws ValueAlreadyInitializedException
     * If the underlying value has already been initialized
     */
    void init(T value);
}
