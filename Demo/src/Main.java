import isaacy2012.observer.Observable;
import isaacy2012.observer.impl.MutableObservable;
import isaacy2012.property.MutableProperty;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        listObservableDemo();
        carDemo();
        propCarDemo();
        ageDemo();
        personDemo();
    }


    private static void listObservableDemo() {
        class Thing {
            public MutableObservable<String> name = Observable.of(MutableProperty.ofEmpty());
            public MutableObservable<List<Thing>> friends = Observable.of(MutableProperty.of(new ArrayList<>()));;

            public Thing(String name) {
                this.name.set(name);
            }

            public void addFriend(Thing friend) {
                this.friends.applyUpdate((friends) -> friends.add(friend));
            }

            @Override
            public String toString() {
                return name.toString();
            }
        }

        Thing adam = new Thing("Adam");
        adam.friends.observe((it) -> System.out.println("Adam has a new friend: " + it));
        Thing bob = new Thing("Bob");
        adam.addFriend(bob);
    }

    private static void carDemo() {
        Car car = new Car("ferrari", 480);
        System.out.println(car);
        car.doStuff();
        System.out.println(car);
    }

    private static void propCarDemo() {
        CarWithProp car = new CarWithProp("ferrari", 480);
        System.out.println(car);
        car.doStuff();
        System.out.println(car);
    }

    private static void ageDemo() {
        PersonAge p = new PersonAge(1997);
        System.out.println(p.birthYear.get()); // 1997
        System.out.println(p.age.get()); // 24
        p.birthYear.set(2005);
        System.out.println(p.age.get()); // 16
        p.age.set(28);
        System.out.println(p.birthYear.get()); // 1993
    }

    private static void personDemo() {
        DemoPerson demoPerson = new DemoPerson("Bob", "Mortimer", 1991, "Hi there!");
        System.out.println(demoPerson);
        demoPerson.age.set(13);
        System.out.println(demoPerson);
        demoPerson.birthYear.set(1965);
        System.out.println(demoPerson);
        demoPerson.greeting.set("");
        System.out.println(demoPerson);
        demoPerson.greeting.set("howdy");
        System.out.println(demoPerson);
        DemoPerson noLastName = new DemoPerson("Alice", null, 1992, "I'm Alice");
        System.out.println(noLastName);
    }
}
