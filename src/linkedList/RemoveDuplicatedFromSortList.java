package linkedList;

import java.util.List;

//leetcode 82
//84.9% solution
public class RemoveDuplicatedFromSortList {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;

        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;


        ListNode newHead = null;
        ListNode pre = null;
        while (current != null) {
            ListNode next = current.next;
            int count = 0;
            while (next != null) {
                if (next.val == current.val) {
                    count++;
                    next = next.next;
                } else {
                    break;
                }
            }
            if (count == 0) {
                if (newHead == null) {
                    newHead = current;
                    pre = newHead;
                } else {
                    pre.next = current;
                    pre = pre.next;
                }
                current = current.next;
            } else {
                current = next;
                if (pre != null) {
                    pre.next = current;
                }
            }
        }


        return newHead;
    }

    public void client() {
        ListNode root = new ListNode(1);
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(3);
        root.next = a;
        a.next = b;
        b.next = c;
        b.next = c;
        c.next = d;
        d.next = null;


        ListNode newNode = deleteDuplicates(root);

        while (newNode != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }


    }
}
