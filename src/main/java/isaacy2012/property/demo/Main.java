package isaacy2012.property.demo;

public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        carDemo();
        propCarDemo();
        ageDemo();
        personDemo();
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
