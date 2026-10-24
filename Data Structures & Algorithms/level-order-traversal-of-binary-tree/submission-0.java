/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        helper(root, levels, 0);
        return levels;
    }

    public void helper(TreeNode root, List<List<Integer>> levels, int depth) {
        if (root == null) return;
        if (levels.size() <= depth) {
            List<Integer> level = new ArrayList<>();
            level.add(root.val);
            levels.add(level);
        } else {
            levels.get(depth).add(root.val);
        }
        helper(root.left, levels, depth+1);
        helper(root.right, levels, depth+1);
    }
}
