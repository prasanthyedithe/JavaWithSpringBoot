package Java11Features.Annotations;

import java.util.Arrays;

public class CustomAnnotation1 {
       public static void main(String[] args) {

           Strudent2 strudent2 = new Strudent2();
         strudent2.Strudent2Test();
    }
}


@interface Test1{}
@interface Test{
    int testing();
    String name() default "SK";
}

@Test(testing = 0)
@Test1
class Student1{
}

@interface Test2{
    int value() default 10;
}

class Strudent2{
    @Test2(value=5) int value;

    public void Strudent2Test(){
        System.out.println(value);
    }

}