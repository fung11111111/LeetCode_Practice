import array.*;
import javaBasic.EqualHashCode;
import javaBasic.ExceptionHandling;
import javaBasic.StaticAndFinal;
import javaBasic.generics.GenericsExample;
import javaBasic.threads.CompletableFutureThread;
import javaBasic.threads.MultiThreadings;
import linkedList.RemoveDuplicatedFromSortList;
import linkedList.RemoveNthNodeFromList;

import java.io.*;
import java.util.logging.Logger;

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

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        BestTimeSellingStock n = new BestTimeSellingStock();
        n.client();



    }


}
