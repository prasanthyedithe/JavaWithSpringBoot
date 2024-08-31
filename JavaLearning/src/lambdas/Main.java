package lambdas;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Persons> listPeople = getPeople();
        sortAge(listPeople);
    }

    // Method to get a list of Person objects
    private static List<Persons> getPeople() {
        List<Persons> result = new ArrayList<>();
        result.add(new Persons("Mike", 33, 1.8));
        result.add(new Persons("Mary", 25, 1.4));
        result.add(new Persons("Alan", 34, 1.7));
        result.add(new Persons("Zoe", 30, 1.5));
        return result;
    }

    // Method to sort the list by age and print the sorted list
    private static void sortAge(List<Persons> listPeople) {
        // a) Sort the list of Person objects by age in ascending order
        listPeople.sort(java.util.Comparator.comparing(Persons::getAge));

        // b) Output the sorted list using the forEach method with a method reference
        listPeople.forEach(System.out::println);
    }
}

// Simple Person class
class Persons {
    private String name;
    private int age;
    private double height;

    public Persons(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public int getAge() {
        return age;
    }
}