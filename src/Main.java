import array.FirstMissingInt;
import array.TrappingWater;
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

//        ConstructGraph c = new ConstructGraph();
//        ConstructGraph.Graph graph = c.createDirectedGraph();
//
//        ConstructGraph.Vertex root = c.createDirectedGraph().getVertexByLabel("a");
//
//       // c.bfs(root, graph);
//        c.dfs(root, graph);

        TrappingWater t = new TrappingWater();
        int [] nums = {4,2,0,3,2,5};
        System.out.println(t.trap(nums));
z
    }


}
