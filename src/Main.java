import array.JumpGame2;
import array.MultiplyString;
import array.RemoveElement;
import backTracking.CombinationSum;
import javaBasic.*;
import javaBasic.desingPattern.BehavioralPattern.CommandPattern;
import javaBasic.desingPattern.creationalPattern.BuilderPattern2;
import javaBasic.desingPattern.structuralPattern.NewFacade.BytesConverter;
import javaBasic.desingPattern.structuralPattern.NewFacade.StringConverter;
import javaBasic.generics.GenericsExample;
import javaBasic.stream.StreamTest;
import javaBasic.threads.CompletableFutureThread;
import javaBasic.threads.MultiThreadings;

import javax.swing.text.html.Option;
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


        BytesConverter bytesConverter = BytesConverter.getConverter();
        StringConverter stringConverter = StringConverter.getConverter();
        byte[] myDrive = new byte[] { (byte)0xe0, 0x4f, (byte)0xd0,
                0x20, (byte)0xea, 0x3a, 0x69, 0x10, (byte)0xa2, (byte)0xd8, 0x08, 0x00, 0x2b,
                0x30, 0x30, (byte)0x9d };
        String myDriveString = "1234";
        System.out.println(bytesConverter.convertToInt(myDrive));
        System.out.println(stringConverter.convertToInt(myDriveString));

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
