package isaacy2012.observable.impl;

import isaacy2012.property.Property;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

/**
 * The type Immutable observable.
 *
 * @param <T> the type parameter
 */
public class ImmutableObservable<T> extends AbstractObservable<T, Property<T>> {

    /**
     * Instantiates a new Immutable observable.
     *
     * @param prop the prop
     */
    public ImmutableObservable(@NotNull Property<T> prop) {
        super(prop);
    }

}
