import array.JumpGame;
import array.ListNode;
import array.ValidParentheses;
import backTracking.LetterCombination;
import backTracking.Permutations;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

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

        JumpGame v = new JumpGame();
        System.out.println(v.canJump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));


    }









}
