import array.FirstMissingInt;
import array.JumpGame;
import array.TrappingWater;
import array.WildcardPattern;
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

        JumpGame j = new JumpGame();


        System.out.println(j.canJump(new int[]{3,2,1,0,4}));

    }


}
