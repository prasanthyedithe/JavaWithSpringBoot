package streams;

import java.util.List;
import java.util.stream.Stream;

import static java.util.List.*;

public class ParallelStream {
    //parallel() is avaliable in Streams & parallelStream() are avaliable in Collections

    public static void main(String[] args) {
        Stream<String> animalsStream = List.of("sheep", "pigs", "horses")
                                           .parallelStream();

        Stream<String> stream = Stream.of("sheep", "pigs", "horses").parallel();
    }
}
