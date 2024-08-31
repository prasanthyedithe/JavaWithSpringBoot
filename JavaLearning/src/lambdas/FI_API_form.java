package lambdas;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FI_API_form {


    public static void main(String[] args) {
        FI_API_form fiApiForm = new FI_API_form();

        fiApiForm.predicate();
        fiApiForm.supplier();
        fiApiForm.consumer();
        fiApiForm.function();
        fiApiForm.unaryBinaryOperations();
    }

    public void predicate() {
        Predicate<String> pStr = s -> s.contains("City");
        System.out.println(pStr.test("ABC City"));

        BiPredicate<String, Integer> biPredicate = (str, len) -> str.length() == len;
        System.out.println(biPredicate.test("ABC", 9));
    }

    public void supplier() {
        Supplier<StringBuilder> sspp = () -> new StringBuilder();
        System.out.println(sspp.get().append("SK"));

        Supplier<LocalTime> supTime = () -> LocalTime.now();
        System.out.println("Supplier time: " + supTime.get());//Supplier time: 09:11:39.121101600

        Supplier<Double> sRandom = () -> Math.random();
        System.out.println(sRandom.get());// e.g. 0.782467864130131
    }

    public void consumer() {
        // Consumer<T> is a functional interface i.e. one abstract method:
        //      void accept(T t)
        Consumer<String> printC = s -> System.out.println(s);// lambda
        printC.accept("To be or not to be, that is the question");

        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Mary");
        names.forEach(printC);  // John, Mary

        // BiConsumer<T, U> is a functional interface i.e. one abstract method:
        //      void accept(T t, U u)
        Map mapCapitalCities = new HashMap<String, String>();
        // Note: The return value of put(k,v) is just ignored (and not returned from the lambda)
        BiConsumer<String, String> biCon = (key, value) -> mapCapitalCities.put(key, value);
        biCon.accept("Dublin", "Ireland");
        biCon.accept("Washington D.C.", "USA");
        System.out.println(mapCapitalCities);// {Dublin=Ireland, Washington D.C.=USA}

        BiConsumer<String, String> mapPrint = (key, value) -> System.out.println(key + " is the capital of: " + value);
        mapCapitalCities.forEach(mapPrint); // Dublin is the capital of: Ireland
        // Washington D.C. is the capital of: USA
    }

    public void function() {
        Function<String, Integer> fun = s -> s.length();
        System.out.println(fun.apply("Prasanth"));

        BiFunction<String, String, Integer> biFun = (s1, s2) -> s1.length() + s2.length();
        System.out.println(biFun.apply("Prasanth", "umar"));
    }


    public void unaryBinaryOperations() {
        // UnaryOperator<T> extends Function<T, T> is a functional interface i.e. one abstract method:
        //      T apply(T t)
        UnaryOperator<String> unaryOp = name -> "My name is " + name;
        System.out.println("UnaryOperator: " + unaryOp.apply("Sean"));// My name is Sean

        // BinaryOperator<T> extends BiFunction<T, T, T> is a functional interface i.e. one abstract method:
        //      T apply(T t1, T t2)
        BinaryOperator<String> binaryOp = (s1, s2) -> s1.concat(s2);
        System.out.println("BinaryOperator: " + binaryOp.apply("William ", "Shakespeare"));// William Shakespeare
    }
}
