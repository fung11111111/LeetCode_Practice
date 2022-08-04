package linkedList;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode getHead() {
        int[] arrToList = new int[]{1, 2};
        ListNode head = new ListNode(arrToList[0]);

        ListNode pre = head;
        for (int i = 1; i < arrToList.length; i++) {
            ListNode current = new ListNode(arrToList[i]);
            pre.next = current;
            pre = current;
        }

        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        int idx = count - n;
        int i = 0;
        current = head;
        ListNode next = head.next;
        ListNode pre = null;
        if (idx == 0) {
            head = head.next;
            return head;
        }
        while (i < idx) {
            pre = current;
            current = current.next;
            next = current.next;
            i++;
        }
        if (pre != null) {
            pre.next = next;
        } else {
            node = null;
        }


        return node;
    }


    public void client() {
        ListNode head = getHead();

        ListNode newHead = removeNthFromEnd(head, 2);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

    }

}
