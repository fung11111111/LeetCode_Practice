import array.JumpGame2;
import array.MultiplyString;
import array.RemoveElement;
import backTracking.CombinationSum;
import javaBasic.*;
import javaBasic.desingPattern.BehavioralPattern.CommandPattern;
import javaBasic.desingPattern.creationalPattern.BuilderPattern2;
import javaBasic.generics.GenericsExample;
import javaBasic.stream.StreamTest;
import javaBasic.threads.CompletableFutureThread;
import javaBasic.threads.MultiThreadings;

import java.io.*;
import java.lang.Enum;

public class Main {

    public static void appendString(String a) {
        a = a + " World!";
    }

    private static void test() {
        int[] a = {1, 2, 4};
        System.out.println(a[3]);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        CommandPattern g = new CommandPattern();
        g.client(); ;

        //  int interval[] = new int[2];

    }

    public static void client() throws IOException, ClassNotFoundException {

        Serialization p = new Serialization("Tom", 20);
        FileOutputStream f = new FileOutputStream("test.txt");

        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(p);
        o.flush();
        o.close();

        FileInputStream i = new FileInputStream("test.txt");
        ObjectInputStream oi = new ObjectInputStream(i);
        Serialization newP = (Serialization) oi.readObject();
        oi.close();
        System.out.println("name" + newP.getName());


    }


}
