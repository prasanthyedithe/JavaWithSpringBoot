package streams;

import javax.swing.text.html.Option;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.*;

public class Streams {

    public static void main(String[] args) {
       // Streams1();
        commonPrimitiveStreamMethods();

    }

    public static void commonPrimitiveStreamMethods() {
        // Primitive Stream : IntStream, LongStream, DoubleStream
        //average() - OptionalDouble
        //max() - OptionalInt,OptionalLong,OptionalDouble
        //min() - OptionalInt,OptionalLong,OptionalDouble
        //sum() - int,long,double

        OptionalInt optionalInt = IntStream.of(10,20,30).max();
        optionalInt.ifPresent(System.out::println);

        OptionalDouble optionalDouble = DoubleStream.of(10.0,20.0,30.0).min();
        // NoSuchElementException is thrown if no value present
        //System.out.println(optionalDouble.orElseThrow());

        OptionalDouble optionalDouble1 =LongStream.of(10L,20L,30L).average();
        System.out.println(optionalDouble1.orElseGet(()->Math.random()));

        IntStream intStream = IntStream.of(10,20,30);

        IntSummaryStatistics intSummaryStatistics =intStream.summaryStatistics();
        System.out.println(intSummaryStatistics);
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getCount());

        Optional<String> s = Optional.ofNullable(null);
        System.out.println(s);
        System.out.println(s.orElseGet(()->"Empty Value"));
    }

    private static void Streams1() {
        List<String> list = Arrays.asList("A","B","C");
        Stream<String> stringStreams = list.stream();
        System.out.print("-----"+stringStreams.count());

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");

        System.out.print("======="+map.entrySet().stream().count());

        Stream.iterate(2, n->n+2).limit(10).forEach(System.out::print);

        Map<Integer,String> integerStringMap = Stream.of("Prasanth","Praveena","Y P Saranya","Y S Shanmukh")
                .collect(Collectors.toMap(s->s.length(),s->s,(s1,s2)->s1+","+s2));
        System.out.println(integerStringMap);


        TreeMap<Integer,String> integerStringTreeMap = Stream.of("Prasanth","Praveena","Y P Saranya","Y S Shanmukh")
                .collect(Collectors.toMap(s->s.length(),s->s,(s1,s2)->s1+s2,()-> new TreeMap<>()));
        System.out.println(integerStringTreeMap);

        Stream<String> stream = Stream.of("cat","cow","elephant","dianose","dianose","rabbit");
        Map<Integer,List<String>> integerStringMap1 =  stream.collect(Collectors.groupingBy(String:: length));
        System.out.println(integerStringMap1);

        Stream<String> stream1 = Stream.of("cat","cow","elephant","dianose","dianose","rabbit");
        Map<Integer,Set<String>> integerStringMap3 =  stream1.collect(Collectors.groupingBy(String:: length,Collectors.toSet()));
        System.out.println(integerStringMap3);

        Stream<String> stream2 = Stream.of("cat","cow","elephant","dianose","dianose","rabbit");
        TreeMap<Integer,List<String>> integerStringMap4 =  stream2.collect(Collectors.groupingBy(String:: length,TreeMap :: new,Collectors.toList()));
        System.out.println(integerStringMap4);


        Stream<String> stream3 = Stream.of("cat","cow","elephant","dianose","dianose","rabbit");
        Map<Boolean,List<String>> integerStringMap2 = stream3.collect(Collectors.partitioningBy(s->s.contains("c")));
        System.out.println(integerStringMap2);

        Stream.of("cat","cow","elephant","dianose","dianose","rabbit")
        .filter(name->name.length()>5).forEach(System.out::println);

        List<Integer> list1= Arrays.asList(1,2,3,4,5,6,7,8);
        List<Integer> list2= Arrays.asList(1,2,3,4,5,6,7,8);
        Stream<List<Integer>> listStreams = Stream.of(list1,list2);
        listStreams.flatMap(listStreams1->listStreams1.stream()).forEach(System.out::println);


        int[] ia ={1,2,3};
        double[] da={1.1,2.2,3.3};
        long[] la={1L,2L,3L};

        IntStream intStream = Arrays.stream(ia);
        DoubleStream doubleStream = Arrays.stream(da);
        LongStream longStream = Arrays.stream(la);

        System.out.println(intStream);
        System.out.println(doubleStream);
        System.out.println(longStream);
    }
}
