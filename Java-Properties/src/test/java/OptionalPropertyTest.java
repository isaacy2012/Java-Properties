import isaacy2012.observable.Observable;
import isaacy2012.observable.impl.MutableObservable;
import isaacy2012.optional.OptionalProperty;
import isaacy2012.optional.impl.MutableOptionalProperty;
import isaacy2012.property.MutableProperty;
import isaacy2012.property.Property;
import isaacy2012.property.ValueProperty;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OptionalPropertyTest {

    @Test
    public void optional_simple() {
        class Thing {
            public MutableOptionalProperty<String> name = OptionalProperty.of(MutableProperty.of("Andy"));
        }

        Thing thing1 = new Thing();
        assertEquals("Andy", thing1.name.get().orElse(null));
        thing1.name.setOptional(null);
        assertEquals(Optional.empty(), thing1.name.get());
    }

}
