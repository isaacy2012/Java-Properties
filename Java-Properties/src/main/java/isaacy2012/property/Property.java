package isaacy2012.property;

import isaacy2012.property.impl.*;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/**
 * Storing a property in this Property automatically gives it a getter.
 * This reduces the need for a getter in the class that has the Property as a field, since
 * it can be final.
 * prop.get();
 *
 * @param <T> the type parameter
 * @author Isaac Young youngisaa/isaacy2012
 */
public interface Property<T> {

    /**
     * Get the value.
     *
     * @return the value
     * @throws isaacy2012.property.exception.ValueNotInitializedException
     * If this Property is a ValueProperty and its value has not been initialized
     */
    T get();

    /**
     * Returns a Property with default setters and getters.
     * Equivalent to Property.withValue(value).build()
     *
     * @param <T>   the type parameter
     * @param value the value
     * @return the value property builder
     */
    static <T> Property<T> of(T value) {
        return withValue(value).build();
    }

    /**
     * Create an empty Property
     *
     * @param <T> the type parameter
     * @return the property
     */
    static <T> ImmutableValueProperty<T> ofEmpty() {
        return new ImmutableValuePropertyBuilder<T>().build();
    }

    /**
     * Create an empty UninitializedValuePropertyBuilder.
     * The parameter must be a casted null, which informs what the type parameter is.
     *
     * @param <T>        the type parameter
     * @param mustBeNull the casted null, that informs the type parameter
     * @return the value property builder
     */
    static <T> ImmutableValuePropertyBuilder<T> withEmpty(T mustBeNull) {
        if (mustBeNull != null) {
            throw new IllegalArgumentException("withEmpty() must be called with a casted null!");
        }
        return new ImmutableValuePropertyBuilder<>();
    }

    /**
     * Creates a PropertyBuilder that contains the passed in value.
     *
     * @param <T>   the type parameter
     * @param value the value
     * @return the value property builder
     */
    static <T> ValuePropertyBuilder<T> withValue(T value) {
        return new ValuePropertyBuilder<>(value);
    }

    /**
     * Creates an ImmutablePropDelegateProperty with the passed in property.
     *
     * @param <T>  the type parameter
     * @param prop the prop
     * @return the mutable property
     */
    static <T> ImmutablePropDelegateProperty<T> ofProperty(@NotNull Property<T> prop) {
        return new PropDelegatePropertyBuilder<>(prop).build();
    }

    /**
     * Creates a PropDelegatePropertyBuilder with the passed in property.
     *
     * @param <T>  the type parameter
     * @param prop the prop
     * @return the prop delegate property builder
     */
    static <T> PropDelegatePropertyBuilder<T> withProperty(@NotNull Property<T> prop) {
        return new PropDelegatePropertyBuilder<>(prop);
    }

    /**
     * Delegate to another field, using a Supplier getter, and build.
     *
     * @param <T>    the type parameter
     * @param getter the getter
     * @return the property
     */
    static <T> Property<T> delegateTo(@NotNull Supplier<T> getter) {
        return new DelegatePropertyBuilder<>(getter).build();
    }

}

