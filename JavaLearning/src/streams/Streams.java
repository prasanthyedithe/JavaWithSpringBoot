package streams;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A","B","C");
        Stream<String> stringStreams = list.stream();
        System.out.print("-----"+stringStreams.count());

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"a");map.put(2,"b");map.put(3,"c");

        System.out.print("======="+map.entrySet().stream().count());

        Stream.iterate(2, n->n+2).limit(10).forEach(System.out::print);

    }
}
