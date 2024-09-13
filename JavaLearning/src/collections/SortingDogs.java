package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingDogs {
    public static void main(String[] args) {
//        comparable(new Dog[]{new Dog("Spot", 2), new Dog("Rover", 7)});// just-in-time array
//        comparable(Arrays.asList(new Dog("Spot", 2), new Dog("Rover", 7)));

  //      comparator(new Dog[]{new Dog("Rover", 7), new Dog("Spot", 2)});
        comparator(Arrays.asList(new Dog1("Rover", 7), new Dog1("Spot", 2)));
    }
    public static void comparable(Dog1[] dogArray){
        Arrays.sort(dogArray);
        System.out.println(Arrays.toString(dogArray));// [Dog{name=Rover, age=7}, Dog{name=Spot, age=2}]
    }
    public static void comparable(List<Dog1> dogList){
        Collections.sort(dogList);
        System.out.println(dogList);// [Dog{name=Rover, age=7}, Dog{name=Spot, age=2}]
    }

    public static void comparator(Dog1[] dogArray){
        // sorts ascending by age
        Comparator<Dog1> byAge = Comparator.comparing(dog -> dog.getAge());
        Arrays.sort(dogArray, byAge);
        System.out.println(Arrays.toString(dogArray));// [Dog{name=Spot, age=2}, Dog{name=Rover, age=7}]

        Comparator<Dog1> byAgeReversed = Comparator.comparing(Dog1::getAge).reversed();
        Arrays.sort(dogArray, byAgeReversed);
        System.out.println(Arrays.toString(dogArray));// [Dog{name=Rover, age=7}, Dog{name=Spot, age=2}]
    }
    public static void comparator(List<Dog1> dogList){
        // sorts ascending by age
        Comparator<Dog1> byAge = Comparator.comparing(Dog1::getAge);
        Collections.sort(dogList, byAge);
        System.out.println(dogList);// [Dog{name=Spot, age=2}, Dog{name=Rover, age=7}]

        Comparator<Dog1> byAgeReversed = Comparator.comparing(Dog1::getAge).reversed();
        Collections.sort(dogList, byAgeReversed);
        System.out.println(dogList);// [Dog{name=Rover, age=7}, Dog{name=Spot, age=2}]
    }
}
