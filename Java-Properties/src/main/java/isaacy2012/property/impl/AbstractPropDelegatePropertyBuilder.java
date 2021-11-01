package isaacy2012.property.impl;

import isaacy2012.property.Property;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

/**
 * The type Abstract prop delegate property builder.
 *
 * @param <T> the type parameter
 * @param <P> the type parameter
 */
public abstract class AbstractPropDelegatePropertyBuilder<T, P extends Property<T>>  {
    /**
     * The Property.
     */
    P _property;
    /**
     * The Getter.
     */
    Function<T, T> getter;


    /**
     * Instantiates a new Abstract prop delegate property builder.
     *
     * @param _property the property
     */
    public AbstractPropDelegatePropertyBuilder(@NotNull P _property) {
        this._property = _property;
    }

}
