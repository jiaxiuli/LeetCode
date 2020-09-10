/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
*/
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
    List list = new ArrayList();
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        dfs(root, 1);
        int max = 0;
       for(int i = 0 ; i < list.size() ; i++ ){
           if((int)list.get(i) > max)
               max = (int)list.get(i);
       }
        return max;
    }
    public TreeNode dfs(TreeNode root, int level){
        if(root==null){
            list.add(level-1);
            return null; 
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
        return null;
    }
}
