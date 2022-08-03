package javaBasic.desingPattern.creationalPattern;

public class SingletonPattern {
    private static SingletonPattern a = new SingletonPattern();

    public static SingletonPattern getSingletonObj(){
        return  a;
    }


}


