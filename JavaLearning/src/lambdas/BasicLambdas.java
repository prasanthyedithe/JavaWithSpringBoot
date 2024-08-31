package lambdas;

interface I {
    void m();

    static void b() {}
    default void c() {}
}
public class BasicLambdas {

    public static void main(String[] args) {
        I lambdaI = () -> {
            System.out.println("First Interface Lambda example");
        };
        lambdaI.m();

        I lambdaI2 = () -> System.out.println("Other way to declaring");
        lambdaI2.m();
    }
}
