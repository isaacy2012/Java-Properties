import isaacy2012.lazy.Lazy;
import isaacy2012.observable.Observable;
import isaacy2012.property.MutableProperty;
import isaacy2012.property.Property;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class LazyTest {

    @Test
    public void immutable_lazy_test() {
        boolean[] supplierCalled = {false};
        class Person {
            final Property<List<Integer>> sortedFavouriteNumbers = Lazy.of(
                    Property.ofEmpty(),
                    () -> {
                        supplierCalled[0] = true;
                        return List.of(9,3,4).stream()
                                .sorted()
                                .collect(Collectors.toList());
                    }
            );
        }
        Person person = new Person();
        assertFalse(supplierCalled[0]);
        assertEquals(List.of(3,4,9), person.sortedFavouriteNumbers.get());
        assertTrue(supplierCalled[0]);
    }

    @Test
    public void mutable_lazy_test() {
        boolean[] supplierCalled = {false};
        class Person {
            final MutableProperty<List<Integer>> sortedFavouriteNumbers = Lazy.of(
                    MutableProperty.ofEmpty(),
                    () -> {
                        supplierCalled[0] = true;
                        return List.of(9,3,4).stream()
                                .sorted()
                                .collect(Collectors.toList());
                    }
            );
        }
        Person person = new Person();
        assertFalse(supplierCalled[0]);
        assertEquals(List.of(3,4,9), person.sortedFavouriteNumbers.get());
        assertTrue(supplierCalled[0]);
        person.sortedFavouriteNumbers.set(List.of(1,2,3));
        assertEquals(List.of(1,2,3), person.sortedFavouriteNumbers.get());
    }
}
