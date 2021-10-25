import isaacy2012.observer.Observable;
import isaacy2012.observer.impl.MutableObservable;
import isaacy2012.property.MutableProperty;
import isaacy2012.property.Property;
import isaacy2012.property.ValueProperty;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObservableTest {

    @Test
    public void observable_simple() {
        class Thing {
            public MutableObservable<String> name = Observable.of(MutableProperty.of("Adam"));
            public MutableObservable<Integer> age = Observable.of(MutableProperty.of(18));

            public void birthday() {
                age.set(age.get()+1);
            }
        }

        Thing thing1 = new Thing();
        String[] output = new String[]{""};
        thing1.age.observe((it) -> output[0] = "The value is now: " + it);
        assertEquals("", output[0]);
        thing1.birthday();
        assertEquals("The value is now: 19", output[0]);
    }

    @Test
    public void observable_list() {
        class Person {
            public final ValueProperty<String> name = Property.ofEmpty();
            public final Observable<List<String>> tasks = Observable.of(Property.of(new ArrayList<>()));

            public Person(String name) {
                this.name.init(name);
            }
        }

        Person adam = new Person("Adam");
        String[] output = new String[]{""};
        adam.tasks.observe((it) -> output[0] = "The value is now: " + it);
        adam.tasks.applyUpdate((it) -> it.add("First task"));
        assertEquals("The value is now: [First task]", output[0]);
        adam.tasks.applyUpdate((it) -> it.add("Second task"));
        assertEquals("The value is now: [First task, Second task]", output[0]);
        assertEquals(List.of("First task", "Second task"), adam.tasks.get());
    }

    @Test
    public void observable_mutable_list() {
        class Person {
            public final ValueProperty<String> name = Property.ofEmpty();
            public final MutableObservable<List<String>> tasks = Observable.of(MutableProperty.of(new ArrayList<>()));

            public Person(String name) {
                this.name.init(name);
            }
        }

        Person adam = new Person("Adam");
        String[] output = new String[]{""};
        adam.tasks.observe((it) -> output[0] = "The value is now: " + it);
        adam.tasks.applyUpdate((it) -> it.add("First task"));
        assertEquals("The value is now: [First task]", output[0]);
        adam.tasks.applyUpdate((it) -> it.add("Second task"));
        assertEquals("The value is now: [First task, Second task]", output[0]);
        assertEquals(List.of("First task", "Second task"), adam.tasks.get());
        adam.tasks.set(new LinkedList<>());
        adam.tasks.applyUpdate((it) -> it.add("LinkedList Task"));
        assertEquals("The value is now: [LinkedList Task]", output[0]);
        assertEquals(List.of("LinkedList Task"), adam.tasks.get());
        assertTrue(adam.tasks.get() instanceof LinkedList);

    }
}
