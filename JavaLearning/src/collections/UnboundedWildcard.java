package collections;

import java.util.ArrayList;
import java.util.List;

public class UnboundedWildcard {
//    public static void showList(List<Object> list){ 
    public static void showList(List<?> list){ // any type is ok
        for(Object o:list){
            System.out.println(o);
        }
        //list.add("test"); // <?> implies read-only
    }
    public static void main(String[] args) {
        // A different variation
        List<String> names = new ArrayList<String>();
        names.add("Sean");
        showList(names); // List<?> list = new ArrayList<String>();
        List<Dog1> dogs = new ArrayList<Dog1>();
        dogs.add(new Dog1());
        showList(dogs); // List<?> list = new ArrayList<Dog>();
        List<Cat1> cats = new ArrayList<Cat1>();
        cats.add(new Cat1());
        showList(cats); // List<?> list = new ArrayList<Cat>();
        
    }    
}


