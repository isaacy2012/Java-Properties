package demo;

import isaacy2012.property.MutableProperty;
import isaacy2012.property.Property;

/**
 * The type Car.
 */
public class Car {
    private int _horsepower;
    /**
     * The Horsepower.
     */
    public final Property<Integer> horsepower = Property.delegateTo(() -> _horsepower);

    private String _name;
    /**
     * The Name.
     */
    public final MutableProperty<String> name = MutableProperty
            .withGetter(() -> _name)
            .withSetter((newValue) -> _name = newValue)
            .build();

    /**
     * Instantiates a new Car.
     *
     * @param name       the name
     * @param horsepower the horsepower
     */
    public Car(String name, int horsepower) {
        this._name = name;
        this._horsepower = horsepower;
    }

    /**
     * Do stuff.
     */
    public void doStuff() {
        _name = "newName";
        _horsepower = 120;

    }

    @Override
    public String toString() {
        return "Car{" +
                "horsepower=" + horsepower +
                ", name=" + name +
                '}';
    }
}
