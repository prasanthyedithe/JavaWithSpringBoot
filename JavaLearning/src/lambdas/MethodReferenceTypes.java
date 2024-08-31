package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class MethodReferenceTypes {

    public static void main(String[] args) {
        boundMethodReferences();
        unboundMethodReferences();
        staticMethodReferences();
        constructorMethodReferences();
    }

    public static void constructorMethodReferences() {
        // Supplier<T>
        //      T get()
        Supplier<StringBuilder> sbL = () -> new StringBuilder();  // lambda
        Supplier<StringBuilder> sbMR = StringBuilder::new;         // method reference
        StringBuilder sb1 = sbL.get();
        sb1.append("lambda version");
        System.out.println(sb1);
        StringBuilder sb2 = sbMR.get();
        sb2.append("method reference version");
        System.out.println(sb2);

        //  Function<T, R>
        //      R apply(T)
        //          List<String> apply(Integer)
        //  ArrayList(int initialCapacity)
        Function<Integer, List<String>> alL = x -> new ArrayList(x);
        Function<Integer, List<String>> alMR = ArrayList::new;
        List<String> ls1 = alL.apply(10);  // size 10
        ls1.add("21");
        System.out.println(ls1);//[21]
        List<String> ls2 = alMR.apply(5);  // size 5
        ls2.add("88");
        System.out.println(ls2);//[88]
    }

    public static void staticMethodReferences() {
        //  Static method references are considered UNBOUND also. An example static method
        //  is Collections.sort(List)
        //  Consumer<T>
        //      void accept(T t)
        //          void accept(List<Integer>)
        //  NB: Consumer takes one parameter => sort(List) is used, as opposed to sort(List, Comparator)
        Consumer<List<Integer>> sortL = list -> Collections.sort(list);
        Consumer<List<Integer>> sortMR = Collections::sort;

        List<Integer> listOfNumbers = Arrays.asList(2, 1, 5, 4, 9);
        sortL.accept(listOfNumbers);// execution
        System.out.println(listOfNumbers);  // [1, 2, 4, 5, 9]

        listOfNumbers = Arrays.asList(8, 12, 4, 3, 7);
        sortMR.accept(listOfNumbers);// execution
        System.out.println(listOfNumbers);  // [3, 4, 7, 8, 12]
    }

    public static void unboundMethodReferences() {

        Function<String, String> str = s -> s.toLowerCase();
        Function<String, String> str1 = String::toLowerCase;
        System.out.println(str.apply("Jaffa"));
        System.out.println(str1.apply("Jaffa"));

        BiFunction<String, String, String> concatL = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> concatMR = String::concat;
        System.out.println(concatL.apply("Sean ", "Kennedy"));// Sean Kennedy

        // 1st parameter is used for executing the instance method
        // "Sean ".concat("Kennedy")
        System.out.println(concatMR.apply("Sean ", "Kennedy"));// Sean Kennedyßß
    }

    public static void boundMethodReferences() {
        String name = "Mr. Joe Bloggs";
        Supplier<String> s1 = () -> name.toLowerCase(); //lambda
        Supplier<String> s2 = name::toLowerCase;//method reference

        System.out.println(s1.get());
        System.out.println(s2.get());

        Predicate<String> titleL = (title) -> name.startsWith(title);
        Predicate<String> titleMR = name::startsWith;

        System.out.println(titleL.test("Mr.")); // true
        System.out.println(titleMR.test("Ms."));// false
    }
}
