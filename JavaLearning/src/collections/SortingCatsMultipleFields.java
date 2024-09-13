package collections;

import collections.Cat1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingCatsMultipleFields {
    public static void main(String[] args) {
        List<Cat1> cats = new ArrayList<>();
        cats.add(new Cat1("Trixy", 5));
        cats.add(new Cat1("Bella", 7));
        cats.add(new Cat1("Bella", 2)); // second Bella
        Comparator<Cat1> compCat = Comparator
                                        .comparing(Cat1::getName)
                                        .thenComparingInt(Cat1::getAge);
        Collections.sort(cats, compCat);
        System.out.println(cats);// [Cat{name=Bella, age=2}, Cat{name=Bella, age=7}, Cat{name=Trixy, age=5}]
    }
    
}
