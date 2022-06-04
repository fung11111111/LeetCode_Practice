import array.*;
import graph.ConstructGraph;

import java.util.List;

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
        GroupAnagrams p = new GroupAnagrams();
        List<List<String>> res = p.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        for(List<String> k: res){
            System.out.println(k.size());
            for(String tmp: k){
                System.out.print(tmp + " ");
            }
            System.out.println();

        }
//        System.out.println(p.searchRange(new int[]{5,7,7,8,8,10}, 8)[1]);








    }


}
