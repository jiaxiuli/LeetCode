/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list = dfs(root,list,1);
        return list;
    }
    public List<List<Integer>> dfs(TreeNode root, List<List<Integer>> list, int level){
        if( root == null )return list;
        if( list.size() < level ){
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(root.val);
            list.add(temp);
        }else{
            list.get(level-1).add(root.val);
        }
        dfs(root.left, list, level+1);
        dfs(root.right, list, level+1);
        return list;
    }
}
