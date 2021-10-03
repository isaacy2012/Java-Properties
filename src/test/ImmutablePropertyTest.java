package test;

import isaacy2012.property.MutableProperty;
import isaacy2012.property.Property;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * The type Immutable property test.
 */
public class ImmutablePropertyTest {
    /**
     * Property same as primative.
     */
    @Test
    void property_same_as_primative() {
        class NumberBox {
            public int _num;
            public final Property<Integer> num;

            public NumberBox(int number) {
                this._num = number;
                this.num = Property.delegateTo(() -> this._num);
            }
        }

        NumberBox numBox = new NumberBox(3);
        assertEquals(numBox._num, numBox.num.get());
        numBox._num = 4;
        assertEquals(numBox._num, numBox.num.get());
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
}
