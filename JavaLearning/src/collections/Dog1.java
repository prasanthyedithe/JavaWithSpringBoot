package collections;

public class Dog1 implements Comparable<Dog1> {
    private String name;
    private Integer age;

    public Dog1(){

    }
    public Dog1(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public Integer getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Dog{" + "name=" + name + ", age=" + age + '}';
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Dog1){
            Dog1 otherDog = (Dog1)obj;
            if(name.equals(otherDog.getName()))
                return true;
        }
        return false;
    }
    /* API:
        The natural ordering for a class C is said to be consistent with equals if and only if 
        e1.compareTo(e2) == 0 has the same boolean value as e1.equals(e2) for every e1 and e2 of class C. 
        It is strongly recommended (though not required) that natural orderings be consistent with equals. 
        This is so because sorted sets (and sorted maps) without explicit comparators behave "strangely" when 
        they are used with elements (or keys) whose natural ordering is inconsistent with equals. */
    @Override
    public int compareTo(Dog1 otherDog){ // specifies "natural ordering" for Dog
        // delegate to String which implements Comparable<String>
        return name.compareTo(otherDog.getName());// sorts alphabetically by name
    }
}
