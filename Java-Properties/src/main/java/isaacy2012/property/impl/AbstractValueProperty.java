package isaacy2012.property.impl;

import isaacy2012.property.ValueProperty;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

/**
 * A Value Property holds a value.
 * A custom getter can be used to map the value to the output.
 *
 * @param <T> the type parameter
 */
public abstract class AbstractValueProperty<T> implements ValueProperty<T> {
    /**
     * The Value.
     */
    protected T value;
    /**
     * The Getter.
     */
    protected final Function<T, T> getter;

    /**
     * Instantiates a new Abstract value property.
     *
     * @param value  the value
     * @param getter the getter
     */
    AbstractValueProperty(T value, @NotNull Function<T, T> getter) {
        this.value = value;
        this.getter = getter;
    }
}
