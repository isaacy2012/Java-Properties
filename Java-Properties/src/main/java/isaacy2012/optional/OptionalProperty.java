package isaacy2012.optional;

import isaacy2012.optional.impl.ImmutableOptionalProperty;
import isaacy2012.optional.impl.MutableOptionalProperty;
import isaacy2012.property.MutableProperty;
import isaacy2012.property.Property;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

/**
 * The interface Optional property.
 *
 * @param <T> the type parameter
 */
public interface OptionalProperty<T> extends Property<Optional<T>> {
    /**
     * Of optional property.
     *
     * @param <T>  the type parameter
     * @param prop the prop
     * @return the optional property
     */
    static <T> OptionalProperty<T> of(@NotNull Property<T> prop) {
        return new ImmutableOptionalProperty(prop);
    }

    /**
     * Of mutable optional property.
     *
     * @param <T>  the type parameter
     * @param prop the prop
     * @return the mutable optional property
     */
    static <T> MutableOptionalProperty<T> of(@NotNull MutableProperty<T> prop) {
        return new MutableOptionalProperty(prop);
    }
}
