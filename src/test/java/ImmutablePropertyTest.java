import isaacy2012.property.*;
import isaacy2012.property.exception.PropertyAlreadyInitializedException;
import isaacy2012.property.exception.PropertyNotInitializedException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Immutable property test.
 */
public class ImmutablePropertyTest {
    /**
     * Property same as primative.
     */
    @Test
    public void property_same_as_primative() {
        class NumberBox {
            public int _num;
            public final Property<Integer> num;

            public NumberBox(int number) {
                this._num = number;
                this.num = Property.delegateTo(() -> this._num);
            }
        }

        NumberBox numBox = new NumberBox(3);
        assertEquals(numBox._num, (int) numBox.num.get());
        numBox._num = 4;
        assertEquals(numBox._num, (int) numBox.num.get());
    }

    /**
     * Property same as object.
     */
    @Test
    void delegate_property_same_as_object() {
        class StringList {
            public List<String> _strings;
            public final Property<List<String>> strings;

            public StringList(List<String> strings) {
                this._strings = strings;
                this.strings = Property.delegateTo(() -> this._strings);
            }
        }

        List<String> words = new ArrayList<>();
        words.add("Hi");
        words.add("Bye");

        StringList strList = new StringList(words);
        assertSame(strList._strings, strList.strings.get());
        strList._strings.add("Goodbye");
        assertEquals(List.of("Hi", "Bye", "Goodbye"), strList.strings.get());
        assertSame(strList._strings, strList.strings.get());
    }

    /**
     * Property same as object.
     */
    @Test
    void prop_delegate_property_same_as_object() {
        class StringList {
            public final MutableProperty<List<String>> _strings = MutableProperty.ofEmpty();
            public final Property<List<String>> strings = Property.ofProperty(_strings);

            public StringList(List<String> strings) {
                this._strings.set(strings);
            }
        }

        List<String> words = new ArrayList<>();
        words.add("Hi");
        words.add("Bye");

        StringList strList = new StringList(words);
        assertSame(strList._strings.get(), strList.strings.get());
        strList._strings.get().add("Goodbye");
        assertEquals(List.of("Hi", "Bye", "Goodbye"), strList.strings.get());
        assertSame(strList._strings.get(), strList.strings.get());
    }

    @Test
    void with_empty_property() {
        class Student {
            public final ValueProperty<String> name = Property.withEmpty((String) null).build();
            public final Property<String> upperName = Property.withProperty(this.name)
                    .withGetter(String::toUpperCase)
                    .build();

        }

        Student student = new Student();
        assertThrows(PropertyNotInitializedException.class, student.name::get);
        assertThrows(PropertyNotInitializedException.class, student.upperName::get);
        student.name.init("Charlie");
        assertEquals("CHARLIE", student.upperName.get());
        assertThrows(PropertyAlreadyInitializedException.class, () -> student.name.init("Bob"));
        assertEquals("CHARLIE", student.upperName.get());
    }

    @Test
    void of_empty_property() {
        class Student {
            public final ValueProperty<String> name = Property.ofEmpty();
            public final Property<String> upperName = Property.withProperty(this.name)
                    .withGetter(String::toUpperCase)
                    .build();

        }

        Student student = new Student();
        assertThrows(PropertyNotInitializedException.class, student.name::get);
        assertThrows(PropertyNotInitializedException.class, student.upperName::get);
        student.name.init("Charlie");
        assertEquals("CHARLIE", student.upperName.get());
        assertThrows(PropertyAlreadyInitializedException.class, () -> student.name.init("Bob"));
        assertEquals("CHARLIE", student.upperName.get());
    }

    @Test
    void of_delegate() {
        class Student {
            public final Property<String> name = Property.of("Adam");
        }

        Student student = new Student();
        assertEquals("Adam", student.name.get());
        assertEquals("Adam", student.name.toString());
    }

    @Test
    void with_delegate() {
        class Student {
            public final Property<String> name = Property.withValue("Adam")
                    .withGetter(String::toUpperCase)
                    .build();
        }

        Student student = new Student();
        assertEquals("ADAM", student.name.get());
        assertEquals("Adam -> ADAM", student.name.toString());
    }

    @Test
    void with_must_be_null() {
        class Student {
            public final Property<String> name = Property.withEmpty("Adam").build();
        }

        Exception exception = assertThrows(RuntimeException.class, Student::new);
        assertEquals("withEmpty() must be called with a casted null!", exception.getMessage());

    }



}
