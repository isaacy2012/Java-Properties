# Java-Properties
Java Properties attempts to emulate C# and Kotlin's properties by wrapping fields around `Property<>` and `MutableProperty<>` classes respectively.

This allows for easier modification when changing the way fields are accessed or set, and eliminating the need for boilerplate `get()` and `set()`V methods: 
```java
class Person {
  public MutableProperty<String> name = MutableProperty.ofEmpty();
  
  Person(String name) {
    this.name.set(name);
  }
}
```

To change this so that the name was always uppercase, the code could simply be changed to add a non-default setter:
```java
class Person {
  public MutableProperty<String> name = MutableProperty.withValue((String) null)
      .withSetter(String::toUpperCase)
      .build();
  
  Person(String name) {
    this.name.set(name);
  }
}
```

Leaving all external code the same with `myPerson.name.get()` to get the value and `myPerson.name.set(String)` to set the value.
