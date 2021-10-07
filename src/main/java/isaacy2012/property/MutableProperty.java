package isaacy2012.property;

import isaacy2012.property.impl.*;

import java.util.function.Function;
import java.util.function.Supplier;

public interface MutableProperty<T> extends Property<T> {
    /**
     * Set.
     *
     * @param value the value
     */
    void set(T value);

    /**
     * Of mutable property.
     *
     * @param <T>   the type parameter
     * @param value the value
     * @return the mutable property
     */
    static <T> MutableProperty<T> of(T value) {
        return withValue(value).build();
    }

    /**
     * Of empty mutable value property builder.
     *
     * @param <T> the type parameter
     * @return the mutable value property builder
     */
    static <T> MutableProperty<T> ofEmpty() {
        return of(null);
    }

    /**
     * With empty mutable value property builder.
     *
     * @param <T>   the type parameter
     * @param clazz the clazz
     * @return the mutable value property builder
     */
    static <T> MutableValuePropertyBuilder<T> withEmpty(T mustBeNull) {
        if (mustBeNull != null) {
            throw new RuntimeException("withEmpty() must be called with a casted null!");
        }
        return withValue(null);
    }

    /**
     * Instantiates a new Property builder.
     *
     * @param <T>   the type parameter
     * @param value the value
     * @return the delegate property builder
     */
    static <T> MutableValuePropertyBuilder<T> withValue(T value) {
        return new MutableValuePropertyBuilder<>(value);
    }

    /**
     * Of property mutable prop delegate property.
     *
     * @param <T>  the type parameter
     * @param prop the prop
     * @return the mutable property
     */
    static <T> MutablePropDelegateProperty<T> ofProperty(MutableProperty<T> prop) {
        return new MutablePropDelegatePropertyBuilder<>(prop)
                .withGetter(Function.identity())
                .withSetter(Function.identity())
                .build();
    }

    /**
     * Instantiates a new Property builder.
     *
     * @param <T>    the type parameter
     * @param getter the getter
     * @return the delegate property builder
     */
    static <T> MutableDelegatePropertyBuilder<T> withGetter(Supplier<T> getter) {
        return new MutableDelegatePropertyBuilder<>(getter);
    }

    /**
     * With property mutable prop delegate property builder.
     *
     * @param <T>  the type parameter
     * @param prop the prop
     * @return the prop delegate property builder
     */
    static <T> MutablePropDelegatePropertyBuilder<T> withProperty(MutableProperty<T> prop) {
        return new MutablePropDelegatePropertyBuilder<>(prop);
    }
}
