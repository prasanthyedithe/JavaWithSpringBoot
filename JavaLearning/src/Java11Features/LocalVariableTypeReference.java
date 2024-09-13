package Java11Features;

public class LocalVariableTypeReference {

    // 1. Where they can be used:
    //      - constructors, methods or init blocks
    // 2. Where they CANNOT be used
    //      - constructors/methods parameters or instance/class variables ("local")
    //      - caveat: lambdas where the parameter type can be inferred!
    // 3. A var is always initialised on the same statement where it is declared.
    //      e.g. var x = 8;
    // 4. The value of var can change but the type cannot.
    // 5. var cannot be simply initialised to null; cast the null to a type first.
    // 6. var not allowed in multi-variable declarations.
    // 7. var is a reserved name but not a reserved word
    //      - var var = 8; //ok
    //      - identifiers can be called var but not type names e.g. classes, interfaces, enums.
    // var x="abc"; ERROR cannot declare it here

    {
        var x="abc";
    }

    LocalVariableTypeReference(){
        var x="abc";
    }
    public static void main(String[] args) {
        var x="abc";
    }
}
