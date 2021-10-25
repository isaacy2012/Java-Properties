package isaacy2012.property.impl;

import com.sun.jdi.Value;
import isaacy2012.property.MutableProperty;
import isaacy2012.property.ValueProperty;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class MutableValueProperty<T> implements MutableProperty<T>, ValueProperty<T> {
    private T value;
    private final Function<T, T> setter;
    private final Function<T, T> getter;

    /**
     * Instantiates a new Delegate property.
     *
     * @param value  the value
     * @param getter the getter
     * @param setter the setter
     */
    MutableValueProperty(T value, @NotNull Function<T, T> getter, @NotNull Function<T, T> setter) {
        this.value = value;
        this.getter = getter;
        this.setter = setter;
    }

    @Override
    public void init(T value) {
        set(value);
    }

    @Override
    public void set(T t) {
        this.value = setter.apply(t);
    }

    @Override
    public T get() {
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
