import array.ListNode;
import backTracking.LetterCombination;

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

        LetterCombination n = new LetterCombination();
        List<String> output = n.letterCombinations("23");
        for (String o : output) {
            System.out.println(o);
        }


    }









}
