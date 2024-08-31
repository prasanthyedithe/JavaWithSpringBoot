package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface Printable<T> {
    void print(T t);
}

interface Retrievable<T> {
    void retrieve(T t);
}

interface Evaluate<T> {
    boolean isNegative(T t);
}

interface Functionable<T, R> {
    void applyThis(T t, R r);
}

class Person {
    private String name;
    private int age;
    private double height;

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }
}

public class LambdasLab {

    public static void main(String[] args) {
        consumer();
        supplier();
        predicate();
        functionable();
        List<Person> listPeople = getPeople();
        sortAge(listPeople);
        sortName(listPeople);
        sortHeight(listPeople);
        methodReference(listPeople);
    }

    public static void methodReference(List<Person> listPeople) {
        System.out.print("--------------------------------");

        listPeople.stream()
                .forEach(System.out::println);

    }

    private static void sortHeight(List<Person> listPeople) {
        // a) Sort the list of Person objects by age in ascending order
        listPeople.sort(java.util.Comparator.comparing(Person::getHeight));

        // b) Output the sorted list using the forEach method
        listPeople.forEach(person -> System.out.println(person.getName() + " - Age: " + person.getHeight()));

    }

    public static void sortName(List<Person> listPeople) {
        // a) Sort the list of Person objects by age in ascending order
        listPeople.sort(java.util.Comparator.comparing(Person::getName));

        // b) Output the sorted list using the forEach method
        listPeople.forEach(person -> System.out.println(person.getName() + " - Age: " + person.getAge()));
    }

    public static void sortAge(List<Person> listPeople) {
        // a) Sort the list of Person objects by age in ascending order
        listPeople.sort(java.util.Comparator.comparing(Person::getAge));

        // b) Output the sorted list using the forEach method
        listPeople.forEach(person -> System.out.println(person.getName() + " - Age: " + person.getAge()));
    }

    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }

    public static void functionable() {

        Functionable<String, Integer> functionable = (str, number) -> System.out.println(str + number);
        functionable.applyThis("Number is: ", 25);

        BiFunction<String, Integer, String> function = (str, number) -> str + number;
        System.out.print(function.apply("Number is: ", 25));
    }

    public static void predicate() {
        Evaluate<Integer> integerEvaluate = integer -> integer < 0;
        System.out.println(integerEvaluate.isNegative(-1));
        System.out.println(integerEvaluate.isNegative(1));


        Predicate<Integer> predicate = integer -> integer < 0;
        System.out.println(predicate.test(-1));
        System.out.println(predicate.test(1));


        System.out.println(check(4, n -> n % 2 == 0));  // true
        System.out.println(check(7, n -> n % 2 == 0));  // false

        // Check if a string starts with "Mr."
        System.out.println(check("Mr. Joe Bloggs", s -> s.startsWith("Mr.")));  // true
        System.out.println(check("Ms. Ann Bloggs", s -> s.startsWith("Mr.")));  // false

        // Check if a person is an adult (age >= 18)
        Person mike = new Person("Mike", 33, 1.8);
        Person ann = new Person("Ann", 13, 1.4);
        System.out.println(check(mike, p -> p.getAge() >= 18));  // true
        System.out.println(check(ann, p -> p.getAge() >= 18));   // false

    }

    // Generic check method
    public static <T> boolean check(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }

    public static void supplier() {

        Retrievable<Integer> retrievable = (Integer t) -> {
            System.out.println("Retrieved value: " + t);
        };

        retrievable.retrieve(77);

        Supplier<Integer> supplier = () -> 77;
        retrievable.retrieve(supplier.get());
    }

    public static void consumer() {
        Printable<String> stringPrintable = str -> System.out.println(str);
        stringPrintable.print("Printable lambda");

        Printable<String> stringPrintable1 = System.out::println;
        stringPrintable1.print("Printable lambda");

        Consumer<String> stringPrintable2 = str -> System.out.println(str);
        stringPrintable2.accept("Printable lambda");

    }
}