package lambdas;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefsAndContext {

    public static void main(String[] args) {
        // No Person being passed in => Supplier
        Supplier<Integer> lambda1 = () -> Person1.howMany();
        Supplier<Integer> mr1 = Person1::howMany;
        System.out.println(lambda1.get());  // 0
        System.out.println(mr1.get());      // 0

        // One Person to be passed in => Function
        Function<Person1, Integer> lambda2 = person -> Person1.howMany(person);
        Function<Person1, Integer> mr2 = Person1::howMany;
        System.out.println(lambda2.apply(new Person1()));  // 1
        System.out.println(mr2.apply(new Person1()));      // 1

        // Two Person's to be passed in => BiFunction
        BiFunction<Person1, Person1, Integer> lambda3 = (p1, p2) -> Person1.howMany(p1, p2);
        BiFunction<Person1, Person1, Integer> mr3 = Person1::howMany;
        System.out.println(lambda3.apply(new Person1(), new Person1()));  // 2
        System.out.println(mr3.apply(new Person1(), new Person1()));      // 2
    }
}

class Person1 {
    public static Integer howMany(Person1... people1) {
        return people1.length;
    }
}
