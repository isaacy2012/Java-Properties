package isaacy2012;

import isaacy2012.property.MutableProperty;
import isaacy2012.property.Property;

import java.time.Year;

public class Person {

    public final Property<String> name;
    public final Property<String> lastName;
    public final MutableProperty<Integer> birthYear;
    public final MutableProperty<Integer> age;
    public final MutableProperty<String> greeting;

    /**
     * Instantiates a new Person.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param birthYear the birth year
     * @param greeting  the greeting
     */
    public Person(String firstName, String lastName, int birthYear, String greeting) {
        this.name = Property.of(firstName)
                .build();

        this.lastName = Property.of(lastName)
                .withGetter((value) -> value != null ? value : "defaultLastName")
                .build();

        this.birthYear = MutableProperty.of(birthYear)
                .build();

        this.age = MutableProperty
                .withGetter(() -> Year.now().getValue() - this.birthYear.get())
                .withSetter((newValue) -> this.birthYear.set(Year.now().getValue() - newValue))
                .build();

        this.greeting = MutableProperty.of(greeting)
                .withGetter(String::toUpperCase)
                .withSetter((newValue) -> {
                    if (newValue.length() != 0) {
                        return newValue;
                    } else {
                        return "defaultValue";
                    }
                })
                .build();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", lastName=" + lastName +
                ", birthYear=" + birthYear +
                ", age=" + age +
                ", message=" + greeting +
                '}';
    }
}
