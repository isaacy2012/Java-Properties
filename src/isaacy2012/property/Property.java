package isaacy2012.property;

import isaacy2012.property.impl.*;

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
     * With value value property builder.
     *
     * @param <T>   the type parameter
     * @param value the value
     * @return the value property builder
     */
    static <T> ValuePropertyBuilder<T> withValue(T value) {
        return new ValuePropertyBuilder<>(value);
    }


    /**
     * Of property mutable property.
     *
     * @param <T>  the type parameter
     * @param prop the prop
     * @return the mutable property
     */
    static <T> ImmutablePropDelegateProperty<T> ofProperty(MutableProperty<T> prop) {
        return new PropDelegatePropertyBuilder<>(prop).build();
    }

    /**
     * Of property prop delegate property builder.
     *
     * @param <T>  the type parameter
     * @param prop the prop
     * @return the prop delegate property builder
     */
    static <T> PropDelegatePropertyBuilder<T> withProperty(MutableProperty<T> prop) {
        return new PropDelegatePropertyBuilder<>(prop);
    }

    /**
     * Delegate to property.
     *
     * @param <T>    the type parameter
     * @param getter the getter
     * @return the property
     */
    static <T> Property<T> delegateTo(Supplier<T> getter) {
        return withGetter(getter).build();
    }

    /**
     * With getter property.
     *
     * @param <T>    the type parameter
     * @param getter the getter
     * @return the property
     */
    static <T> DelegatePropertyBuilder<T> withGetter(Supplier<T> getter) {
        return new DelegatePropertyBuilder<>(getter);
    }


}

