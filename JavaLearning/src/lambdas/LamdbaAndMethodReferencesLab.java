package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class LamdbaAndMethodReferencesLab {

    public static void main(String[] args) {
        staticMR();
        boundedMR();
        unboundedMR();
        constroctorMR();

    }

    public static void constroctorMR() {
        //a. Code a Supplier typed for List<String> that returns a new ArrayList
        Supplier<List<String>> listSupplier = () -> new ArrayList<>();
        //b. Invoke the lambda to create a new List<String> named list
        List<String> list = listSupplier.get();
        //c. Add "Lambda" to the list
        list.add("Lambda");
        //d. Output the list to show it worked
        list.forEach(System.out::println);
        //e. Code the method reference version
        Supplier<List<String>> listSupplierMethodRef = ArrayList::new;
        //i. Re-initialize list by invoking the method reference version
        list = listSupplierMethodRef.get();
        //ii. Add "Method Reference" to the list
        list.add("Method Reference");
        //iii. Output the list to show it worked
        list.forEach(System.out::println);
        //f. Use the overloaded ArrayList constructor passing in 10 as the initial capacity
        Function<Integer, List<String>> listWithCapacity = capacity -> new ArrayList<>(capacity);
        //iv. Re-initialize list by invoking the lambda passing in 10 as the capacity
        list = listWithCapacity.apply(10);
        // v. Add "Lambda" to the list
        list.add("Lambda");
        //vi. Output the list to show it worked
        System.out.println("List with capacity: " + list); // Output should be [Lambda]
        //g. Code the method reference version
        Function<Integer, List<String>> listWithCapacityMethodRef = ArrayList::new;
        //h. Re-initialize list by invoking the method reference version and repeat the steps
        list = listWithCapacityMethodRef.apply(10);
        list.add("Method Reference");
        System.out.println("List with capacity using method reference: " + list);
    }

    public static void unboundedMR() {
        //a. Code a Predicate lambda typed for String that checks if the string passed in is empty
        Predicate<String> isEmpty = str -> str.isEmpty();
        //b. Invoke the lambda passing in ""
        System.out.println(isEmpty.test("")); // Output should be true
        //c. Invoke the lambda passing in "xyz"
        System.out.println(isEmpty.test("xyz")); // Output should be false
        //d. Code the method reference version
        Predicate<String> isEmptyString = String::isEmpty;
        //e. Repeat b and c using the method reference version
        System.out.println(isEmptyString.test("")); // Output should be true
        System.out.println(isEmptyString.test("xyz")); // Output should be false
        //f. Code a BiPredicate lambda typed for String and String
        BiPredicate<String, String> startsWithPrefix = (str, prefix) -> str.startsWith(prefix);
        //g. Code the method reference version
        BiPredicate<String, String> startsWithPrefixMethodRef = String::startsWith;
        //h. Test it as per f.iii
        System.out.println(startsWithPrefixMethodRef.test("Mr. Joe Bloggs", "Mr.")); // Output should be true
        System.out.println(startsWithPrefixMethodRef.test("Mr. Joe Bloggs", "Ms.")); // Output should be false

    }

    public static void boundedMR() {
        //a. Declare a String variable called name and initialize it to "Mr. Joe Bloggs"
        String name = "Mr. Joe Bloggs";
        //b. Using a Predicate typed for String, code a lambda that checks if name starts with the prefix passed in
        Predicate<String> predicateString = prefix -> name.startsWith(prefix);
        //c. Invoke the lambda passing in "Mr."
        System.out.print(predicateString.test("Mr."));
        //d. Invoke the lambda passing in "Ms."
        System.out.print(predicateString.test("Ms."));
        //e. Code the method reference version
        Predicate<String> predicateStringMR = name::startsWith;
        //f. Repeat c and d using the method reference version
        System.out.println(predicateStringMR.test("Mr."));
        System.out.println(predicateStringMR.test("Ms."));

    }

    private static void staticMR() {
        //a. Declare a List of integers with values 1, 2, 7, 4, and 5
        List<Integer> staticList = Arrays.asList(1, 2, 7, 4, 5);
        //b. Use a Consumer typed for List<Integer> and the Collections.sort static method to sort the list
        Consumer<List<Integer>> sortedList = list -> Collections.sort(list);
        // c. Invoke the lambda
        sortedList.accept(staticList);
        //d. Prove that the sort worked
        System.out.println("Sorted list: " + staticList);
        //e. Re-initialize the list
        staticList = Arrays.asList(1, 2, 7, 4, 5);
        //f. Code the method reference version
        Consumer<List<Integer>> sortedListMF = Collections::sort;
        sortedListMF.accept(staticList);
        System.out.println("Sorted list: " + staticList);


    }
}
