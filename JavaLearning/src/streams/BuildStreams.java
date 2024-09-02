package streams;


import java.util.Arrays;
import java.util.stream.Stream;

class Dog{

}
public class BuildStreams {

    public static void main(String[] args) {
        Stream<String> strStream = Stream.of("A","B","C");
        System.out.println(strStream.count());

        Stream<Dog> dogStream = Stream.of(new Dog());
        System.out.println(dogStream.count());
    }
}
