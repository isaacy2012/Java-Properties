import isaacy2012.optional.OptionalProperty;
import isaacy2012.optional.impl.MutableOptionalProperty;
import isaacy2012.property.MutableProperty;
import org.junit.jupiter.api.Test;

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
        thing1.name.set(null);
        assertEquals(Optional.empty(), thing1.name.get());
    }

}
