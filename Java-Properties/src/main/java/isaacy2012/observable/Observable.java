package isaacy2012.observable;

import isaacy2012.observable.impl.ImmutableObservable;
import isaacy2012.observable.impl.MutableObservable;
import isaacy2012.property.MutableProperty;
import isaacy2012.property.Property;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

/**
 * The interface Observable.
 *
 * @param <T> the type parameter
 */
public interface Observable<T> extends Property<T> {

    /**
     * Listen.
     *
     * @param observer the observer
     */
    void observe(@NotNull Observer<T> observer);


    /**
     * Mutate r.
     *
     * @param <R> the type parameter
     * @param mut the mut
     * @return the r
     */
    <R> R applyUpdate(@NotNull Function<T, R> mut);

    /**
     * Of mutable observable.
     *
     * @param <T>  the type parameter
     * @param prop the prop
     * @return the mutable observable
     */
    static <T> MutableObservable<T> of(@NotNull MutableProperty<T> prop) {
        return new MutableObservable<T>(prop);
    }

    static <T> Observable<T> of(@NotNull Property<T> prop) {
        return new ImmutableObservable<T>(prop);
    }
}
