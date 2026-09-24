package trees;

/*
 * LeetCode 100 - Same Tree
 *
 * Difficulty: Easy
 * Topic: Trees
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Idea:
 * Recursively compare the left and right subtrees of both trees.
 * Return true when both nodes are null.
 * Return false when only one node is null or when their values are different.
 * If all corresponding nodes have the same values and both subtrees are the same, return true.
 *
 * Learned:
 * - Learned how to compare two binary trees recursively.
 * - Practiced using multiple base cases in recursion.
 * - Learned how recursive calls return boolean results that can be combined.
 * - Practiced checking both subtrees and the current node.
 *
 * Solved: 2026-09-24
 */

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null) return true;
        if((p == null && q != null) || (p != null && q == null)) return false;

        boolean leftChild = isSameTree(p.left, q.left);
        boolean rightChild = isSameTree(p.right,q.right);

        if(p.val != q.val || !leftChild || !rightChild) return false;

        return true;
    }
}