package demo;

import isaacy2012.property.MutableProperty;

import java.time.Year;

/**
 * The type Person age.
 */
public class PersonAge {
    /**
     * The Birth year.
     */
    public final MutableProperty<Integer> birthYear;
    /**
     * The Age. The age is a DelegateMutableProperty that delegates to birthYear
     */
    public final MutableProperty<Integer> age;

    /**
     * Instantiates a new Person age.
     *
     * @param birthYear the birth year
     */
    public PersonAge(int birthYear) {
        this.birthYear = MutableProperty.of(birthYear);

        this.age = MutableProperty
                .withGetter(() -> Year.now().getValue() - this.birthYear.get())
                .withSetter((newValue) -> this.birthYear.set(Year.now().getValue() - newValue))
                .build();
    }

    @Override
    public String toString() {
        return "PersonAge{" +
                "birthYear=" + birthYear +
                ", age=" + age +
                '}';
    }
}
