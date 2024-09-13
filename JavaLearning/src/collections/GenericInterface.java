package collections;

interface Moveable<T>{
    void move(T t);
}
class MoveFeline implements Moveable<Cat1>{
    public void move(Cat1 c){}
}
class MoveCanine implements Moveable<Dog1>{
    public void move(Dog1 d){}
}
class SomeMoveable<U> implements Moveable<U>{
    public void move(U u){}
}
public class GenericInterface {
    public static void main(String[] args) {
        new MoveFeline().move(new Cat1());
        //new MoveFeline().move(new Dog()); // compiler error
        new MoveCanine().move(new Dog1());
       // new MoveCanine().move(new Cat()); // compiler error

        new SomeMoveable<Dog1>().move(new Dog1());
        new SomeMoveable<Cat1>().move(new Cat1());
    }
}



class RawMoveable implements Moveable{ // old way
    public void move(Object o){}
}
