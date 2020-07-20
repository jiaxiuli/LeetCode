/*
Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9  
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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        list = dfs(root, list);
        Collections.sort(list);
        TreeNode res = new TreeNode(list.get(0));
        for( int i = 1 ; i < list.size() ; i++ ){
            res = insertRight(res, list.get(i));
        }
        return res;
    }
    public List<Integer> dfs(TreeNode root, List<Integer> list){
        if( root == null )return list;
        list.add(root.val);
        list = dfs( root.left, list );
        list = dfs( root.right, list);
        return list;
    }
    public TreeNode insertRight(TreeNode root, int val){
        if( root == null ){
            root = new TreeNode(val);
            return root;
        }
        root.right = insertRight(root.right, val);
        return root;
        
    }
}
