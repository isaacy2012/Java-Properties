import isaacy2012.property.MutableProperty;
import isaacy2012.property.Property;
import isaacy2012.property.ValueProperty;
import isaacy2012.property.exception.ValueAlreadyInitializedException;
import isaacy2012.property.exception.ValueNotInitializedException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Immutable property test.
 */
public class MutablePropertyTest {
    /**
     * Property same as primative.
     */
    @Test
    public void property_same_as_primative() {
        class NumberBox {
            public int _num;
            public final MutableProperty<Integer> num;

            public NumberBox(int number) {
                this._num = number;
                this.num = MutableProperty
                        .withGetter(() -> this._num)
                        .withSetter((it) -> this._num = it)
                        .build();
            }
        }

        NumberBox numBox = new NumberBox(3);
        assertEquals(numBox._num, (int) numBox.num.get());
        numBox._num = 4;
        assertEquals(numBox._num, (int) numBox.num.get());
        numBox.num.set(5);
        assertEquals(5, (int) numBox.num.get());
    }

    /**
     * Property same as object.
     */
    @Test
    void delegate_property_same_as_object() {
        class StringList {
            public List<String> _strings;
            public final MutableProperty<List<String>> strings;

            public StringList(List<String> strings) {
                this._strings = strings;
                this.strings = MutableProperty
                        .withGetter(() -> this._strings)
                        .withSetter((it) -> this._strings = it)
                        .build();
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
        strList.strings.set(List.of("A", "B", "C"));
        assertEquals(List.of("A", "B", "C"), strList._strings);
        assertSame(strList._strings, strList.strings.get());
    }

    /**
     * Property same as object.
     */
    @Test
    void prop_delegate_property_same_as_object() {
        class StringList {
            public final MutableProperty<List<String>> _strings = MutableProperty.ofEmpty();
            public final MutableProperty<List<String>> strings = MutableProperty.ofProperty(_strings);

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
        strList.strings.set(List.of("1", "2", "3"));
        assertEquals(List.of("1", "2", "3"), strList._strings.get());
        assertSame(strList._strings.get(), strList.strings.get());
    }

    @Test
    void of_value() {
        class Student {
            public final MutableProperty<String> name = MutableProperty.of("Adam");
        }

        Student student = new Student();
        assertEquals("Adam", student.name.get());
        assertEquals("Adam", student.name.toString());
        student.name.set("Bobby");
        assertEquals("Bobby", student.name.toString());
    }

    @Test
    void with_value() {
        class Student {
            public final MutableProperty<String> name = MutableProperty.withValue("Adam")
                    .withGetter(String::toUpperCase)
                    .build();
        }

        Student student = new Student();
        assertEquals("ADAM", student.name.get());
        assertEquals("Adam -> ADAM", student.name.toString());
        student.name.set("bobby");
        assertEquals("BOBBY", student.name.get());
        assertEquals("bobby -> BOBBY", student.name.toString());
    }

    @Test
    void of_property() {
        class Student {
            public MutableProperty<String> _name = MutableProperty.of("Adam");
            public final MutableProperty<String> name = MutableProperty.ofProperty(_name);
            public final MutableProperty<String> uppercaseName = MutableProperty.withProperty(_name)
                    .withGetter(String::toUpperCase)
                    .build();
        }

        Student student = new Student();
        assertEquals("Adam", student.name.get());
        assertEquals("Adam", student.name.toString());
        assertEquals("ADAM", student.uppercaseName.get());
        assertEquals("Adam -> ADAM", student.uppercaseName.toString());
        student.name.set("Bobby");
        assertEquals("Bobby", student.name.get());
        assertEquals("Bobby", student.name.toString());
        assertEquals("BOBBY", student.uppercaseName.get());
        assertEquals("Bobby -> BOBBY", student.uppercaseName.toString());
    }

    @Test
    void of_uninitialized_with_getter_and_setter() {
        class Student {
            public final MutableProperty<String> name = MutableProperty.withEmpty((String) null)
                    .withGetter(String::toUpperCase)
                    .withSetter((it) -> it.replace(" ", "-"))
                    .build();
        }

        Student student = new Student();
        student.name.set("Adam Bob");
        assertEquals("ADAM-BOB", student.name.get());
        assertEquals("Adam-Bob -> ADAM-BOB", student.name.toString());
    }

    @Test
    void with_must_be_null() {
        class Student {
            public final MutableProperty<String> name = MutableProperty.withEmpty("Adam").build();
        }

        Exception exception = assertThrows(RuntimeException.class, Student::new);
        assertEquals("withEmpty() must be called with a casted null!", exception.getMessage());
    }



}
