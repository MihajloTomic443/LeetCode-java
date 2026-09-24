package trees;

/*
 * LeetCode 104 - Maximum Depth of Binary Tree
 *
 * Difficulty: Easy
 * Topic: Trees
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Idea:
 * Recursively calculate the depth of the left and right subtrees.
 * Take the greater depth and add 1 for the current node.
 * Return 0 when the current node is null.
 *
 * Learned:
 * - Learned how recursion works with binary trees.
 * - Practiced calculating the depth of a binary tree recursively.
 * - Learned how to use the base case when the node is null.
 * - Practiced using Math.max() to choose the deeper subtree.
 *
 * Solved: 2026-09-24
 */

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftChild = maxDepth(root.left);
        int rightChild = maxDepth(root.right);

        return Math.max(leftChild, rightChild) + 1;
    }
}