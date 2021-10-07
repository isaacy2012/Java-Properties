import isaacy2012.property.MutableProperty;
import isaacy2012.property.Property;

class Person {
    public final MutableProperty<String> name = MutableProperty.ofEmpty();
    public final Property<String> uppercaseName = Property.withProperty(name)
            .withGetter(String::toUpperCase)
            .build();

    Person(String name) {
        this.name.set(name);
    }
}
