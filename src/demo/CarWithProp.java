package demo;

import isaacy2012.property.MutableProperty;
import isaacy2012.property.Property;

/**
 * The type Car with prop.
 */
public class CarWithProp {
    private final MutableProperty<Integer> _horsepower;
    /**
     * The Horsepower.
     */
    public final Property<Integer> horsepower;

    private final MutableProperty<String> _name;
    /**
     * The Name.
     */
    public final MutableProperty<String> name;

    /**
     * Instantiates a new Car.
     *
     * @param name       the name
     * @param horsepower the horsepower
     */
    public CarWithProp(String name, int horsepower) {
        this._name = MutableProperty.of(name);
        this.name = MutableProperty.ofProperty(_name);
        this._horsepower = MutableProperty.of(horsepower);
        this.horsepower = Property.ofProperty(_horsepower);
    }

    /**
     * Do stuff.
     */
    public void doStuff() {
        _name.set("newName");
        _horsepower.set(120);
    }

    @Override
    public String toString() {
        return "Car{" +
                "horsepower=" + horsepower +
                ", name=" + name +
                '}';
    }
}
