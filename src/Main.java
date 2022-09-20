import array.JumpGame2;
import array.RemoveElement;
import backTracking.CombinationSum;
import javaBasic.*;
import javaBasic.generics.GenericsExample;
import javaBasic.stream.StreamTest;
import javaBasic.threads.MultiThreadings;

import java.io.*;

public class Main {
    /**
     * Definition for singly-linked list.
     * public class array.ListNode {
     * int val;
     * array.ListNode next;
     * array.ListNode() {}
     * array.ListNode(int val) { this.val = val; }
     * array.ListNode(int val, array.ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public static void appendString(String a) {
        a = a + " World!";
    }

    private static void test() {
        int[] a = {1, 2, 4};
        System.out.println(a[3]);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Main m = new Main();


        FunctionalInter g = new FunctionalInter();
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
