/*Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false*/

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        String strp = "";
        String strq = "";
        strp = dfs(p, strp);
        strq = dfs(q, strq);
        System.out.println(strp);
        System.out.println(strq);
        return strp.equals(strq);
        
    }
    public String dfs(TreeNode root, String str){
        if( root == null ){
            str += "0";
            return str;
        } 
        str = str + root.val;
        str = dfs(root.left, str);
        str = dfs(root.right, str);
        return str;
    }
}
