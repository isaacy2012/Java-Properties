package isaacy2012.property.impl;

import isaacy2012.property.exception.ValueAlreadyInitializedException;
import isaacy2012.property.exception.ValueNotInitializedException;

import java.util.function.Function;

/**
 * The type Immutable value property.
 *
 * @param <T> the type parameter
 */
public class ImmutableValueProperty<T> extends AbstractValueProperty<T> {
    /**
     * Whether this property has been initialized yet
     */
    private boolean initialized;


    /**
     * Instantiates a new Delegate property.
     *
     * @param value       the value
     * @param getter      the getter
     * @param initialized the initialized
     */
    ImmutableValueProperty(T value, Function<T, T> getter, boolean initialized) {
        super(value, getter);
        this.initialized = initialized;
    }

    @Override
    public void init(T t) {
        if (initialized) {
            throw new ValueAlreadyInitializedException("Property has already been initialized!");
        }
        this.value = t;
        initialized = true;
    }

    @Override
    public T get() {
        if (!initialized) {
            throw new ValueNotInitializedException("Property has not been initialized yet!");
        }
        return getter.apply(value);
    }

    @Override
    public String toString() {
        if (value == get()) {
            return value.toString();
        } else {
            return value + " -> " + get().toString();
        }
    }
}
