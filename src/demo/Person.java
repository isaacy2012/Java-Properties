package demo;

import isaacy2012.property.MutableProperty;

class Person {
    public final MutableProperty<String> name = MutableProperty.withEmpty((String) null)
            .withSetter(String::toUpperCase)
            .build();

    Person(String name) {
        this.name.set(name);
    }
}
