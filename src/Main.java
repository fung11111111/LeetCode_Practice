import array.*;
import graph.ConstructGraph;

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


    public class TreeNode {
        String val;
        Integer key;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }
    }


    public static void main(String[] args) {
        Main m = new Main();
        FirstAndLastPosition p = new FirstAndLastPosition();
        System.out.println(p.searchRange(new int[]{5,7,7,8,8,10}, 8)[0]);
        System.out.println(p.searchRange(new int[]{5,7,7,8,8,10}, 8)[1]);



    }


}
