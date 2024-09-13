package Java11Features;

interface Tennis{
    private static void hit(String stroke){
        System.out.println("Hitting a "+stroke);
    }
    private void smash(){ hit("smash"); }
    default void forehand(){ hit("forehand"); }
    static void backhand(){ 
        //smash();// static to instance not allowed!
        hit("backhand"); 
    }
}
public class PrivateInterfaceMethod implements Tennis{
    public static void main(String[] args) {
        new PrivateInterfaceMethod().forehand(); // Hitting a forehand
        Tennis.backhand();          // Hitting a backhand
       // new PrivateInterfaceMethod().hit();
        //new PrivateInterfaceMethod().smash();
    }
}



