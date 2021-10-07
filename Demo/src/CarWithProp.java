import isaacy2012.property.MutableProperty;
import isaacy2012.property.Property;

/**
 * The type Car with prop.
 */
public class CarWithProp {
    private final MutableProperty<Integer> _horsepower = MutableProperty.ofEmpty();
    /**
     * The Horsepower.
     */
    public final Property<Integer> horsepower = Property.ofProperty(_horsepower);

    private final MutableProperty<String> _name = MutableProperty.ofEmpty();
    /**
     * The Name.
     */
    public final MutableProperty<String> name = MutableProperty.ofProperty(_name);

    /**
     * Instantiates a new Car.
     *
     * @param name       the name
     * @param horsepower the horsepower
     */
    public CarWithProp(String name, int horsepower) {
        this._name.set(name);
        this._horsepower.set(horsepower);
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
