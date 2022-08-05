package javaBasic;

public class StaticAndFinal {

    class FinalClass{
        //keyword used to apply restrictions on classes, methods and variables
        //can't be inherited and overriden
        //need to initialize the var and cannot change the value
        //final variable -> create constant
        //final methods -> prevent overriding
        // final class -> prevent inheritance

    }

    //static is for memory management
    //get memoru only once in the class area at the time of class loading

    //only access inside the class
    private static int counter = 0;

    //can access outside the class
    public static int counter2 = 0;
    private String say = "Hello";

    public StaticAndFinal() {
        counter++;
        System.out.println(counter);
    }


    //static method belongs to class instead of Object
    // can be invoked without creating the instance
    //can access static data member and change the value
    //e.g. StaticAndFinal.addCounterAndPrint
    public static void addCounterAndPrint() {
        System.out.println(++counter);


        //cannot call non static member or method
        //System.out.println(say);
        //print();
    }

    public void print() {
        System.out.println("non static");
    }
}
