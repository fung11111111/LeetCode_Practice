package binaryTree;

import java.util.Map;

public class BinaryTree {
    public class TreeNode {
        String val;
        Integer key;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }
    }


    public TreeNode constructBST(Map<Integer, String> datamap, Integer[] nums) {
        TreeNode root = null;

        for (Integer num : nums) {
            Integer key = num;
            String val = datamap.get(key);
            TreeNode current = new TreeNode();
            current.val = val;
            current.key = key;
            if (root == null) {
                root = current;
            } else {
                TreeNode parent = getParentNode(root, key);
                if (current.key > parent.key) {
                    parent.right = current;
                } else {
                    parent.left = current;
                }
            }


        }


        return root;
    }

    public TreeNode getParentNode(TreeNode root, Integer key) {
        TreeNode node = root;
        if (key < root.key) {
            return root.left != null ? getParentNode(node.left, key) : node;
        } else {
            return root.right != null ? getParentNode(node.right, key) : node;
        }
    }

    public TreeNode searchNode(TreeNode root, Integer key) {
        TreeNode node = root;
        if (node.key == key) return node;
        if (key < node.key) {
            return node.left != null ? searchNode(node.left, key) : node;
        } else {
            return node.right != null ? searchNode(node.right, key) : node;
        }
    }

    public void insertNode(TreeNode root, Integer key, String val) {
        TreeNode parent = getParentNode(root, key);
        TreeNode current = new TreeNode();
        current.val = val;
        current.key = key;
        if (parent != null && key < parent.key) {
            parent.left = current;
        } else {
            parent.right = current;
        }

    }
}
