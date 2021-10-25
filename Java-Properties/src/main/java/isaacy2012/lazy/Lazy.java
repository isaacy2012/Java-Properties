package isaacy2012.lazy;

import isaacy2012.lazy.impl.ImmutableLazyProperty;
import isaacy2012.property.MutableProperty;
import isaacy2012.property.Property;
import isaacy2012.property.ValueProperty;
import isaacy2012.property.impl.MutableValueProperty;

public interface Lazy<T> extends Property<T> {
    public static <T> Property<T> of(ValueProperty<T> prop) {
        return new ImmutableLazyProperty<T>(prop);
    }

    public static <T> MutableProperty<T> of(MutableValueProperty<T> prop) {
        return new ImmutableLazyProperty<T>(prop);
    }
}
