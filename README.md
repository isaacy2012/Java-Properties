# Java-Properties
Java Properties attempts to emulate C# and Kotlin's properties by wrapping fields around `Property<>` and `MutableProperty<>` classes.

# Installation
See the "releases" tag on the sidebar, download the JAR, and import it into your project!


# Advantages
- Enforces the use of `name.set(newName)` and `name.get()` everywhere, even within the class. If different behaviour is required within and outside the class, a private Property can be used with a public Property that delegates to the private one with `Property.ofProperty(otherProperty)`.
- Allows for easier modification when changing the way fields are accessed or set, and eliminating the need for boilerplate `getName()` and `setName()` setter and getter methods.


# Usage
To define a `Person` class with a single property `name` that is mutable:
```java
class Person {
  public final MutableProperty<String> name = MutableProperty.ofEmpty();
  
  Person(String name) {
    this.name.set(name);
  }
}
```

To change this so that the name is always uppercase, the code can simply be changed to add a custom setter:
```java
class Person {
  public final MutableProperty<String> name = MutableProperty.withValue((String) null)
      .withSetter(String::toUpperCase)
      .build();
  
  Person(String name) {
    this.name.set(name);
  }
}
```

Alternatively, to have another property that relies on the value of `name`, say, `uppercaseName`, we can use `ofProperty`, which we can then add a custom getter to such that `uppercaseName.get()` is equivalent to `name.get().toUpperCase()`:
```java
class Person {
    public final MutableProperty<String> name = MutableProperty.ofEmpty();
    public final Property<String> uppercaseName = Property.withProperty(name)
            .withGetter(String::toUpperCase)
            .build();

    Person(String name) {
        this.name.set(name);
    }
}
```

Leaving all external code the same with `myPerson.name.get()` to get the value and `myPerson.name.set(String)` to set the value.
