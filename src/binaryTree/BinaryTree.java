package binaryTree;

import java.util.*;

public class BinaryTree {
    public class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        public TreeNode() {
        }

        public Integer getVal() {
            return val;
        }
    }


    public TreeNode constructBST() {
        TreeNode root = null;
        List<Integer> nums = Arrays.asList(Integer.valueOf(5), Integer.valueOf(9), Integer.valueOf(3), Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(6));

        for (Integer num : nums) {
            TreeNode current = new TreeNode();
            current.val = num;
            if (root == null) {
                root = current;
            } else {
                TreeNode parentNode = getParentNode(root, num);
                current.parent = parentNode;
                if (current.val <= parentNode.val) {
                    parentNode.left = current;
                } else {
                    parentNode.right = current;
                }
            }

        }

        return root;
    }

    //for binary search tree
    public TreeNode getSuccessor(TreeNode root) {
        if (root != null && root.right != null) {
            return getMinNodeFromSubTree(root.right);
        }
        return root;
    }

    public TreeNode getPredecessor(TreeNode root) {
        if (root != null && root.left != null) {
            return getMaxNodeFromSubTree(root.left);
        }
        return root;
    }

    public TreeNode getMinNodeFromSubTree(TreeNode node) {
        if (node != null) {
            TreeNode current = node;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        }
        return null;
    }

    public TreeNode getMaxNodeFromSubTree(TreeNode node) {
        if (node != null) {
            TreeNode current = node;
            while (current.right != null) {
                current = current.right;
            }
            return current;
        }
        return null;
    }

    public TreeNode getParentNode(TreeNode root, Integer val) {
        TreeNode node = root;
        if (val < root.val) {
            return root.left != null ? getParentNode(node.left, val) : node;
        } else {
            return root.right != null ? getParentNode(node.right, val) : node;
        }

    }

    public void printNodePreOrder(TreeNode root) {
        TreeNode current = root;
        if (current != null) {
            System.out.println(current.val);
            printNodePreOrder(root.left);
            printNodePreOrder(root.right);
        }
    }

    public void printNodeInOrder(TreeNode root) {
        //ascending order
        TreeNode current = root;
        if (current != null) {
            printNodeInOrder(root.left);
            System.out.println(current.val);
            printNodeInOrder(root.right);
        }
    }

    public void printNodePostOrder(TreeNode root) {
        TreeNode current = root;
        if (current != null) {
            printNodePostOrder(root.left);
            printNodePostOrder(root.right);
            System.out.println(current.val);
        }
    }

    public void printNodeLevelOrder(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode n = queue.poll();
                TreeNode left = n.left;
                TreeNode right = n.right;
                if (n != null) {
                    System.out.println(n.val);
                }
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
            }


        }
    }


}
