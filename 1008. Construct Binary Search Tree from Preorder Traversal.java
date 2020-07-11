/*
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode();
		if( preorder.length == 0 ) System.out.println(root);
		
		root.val = preorder[0];
		
		for( int i = 1 ; i < preorder.length ; i++ ) {
			TreeNode node = new TreeNode(preorder[i]);
			root = dfs(root,node);
		}
        return root;
    }
     public static TreeNode dfs(TreeNode root, TreeNode node){
	      if( root == null) { root = node; return root;}
	      
	      if( node.val > root.val) root.right = dfs(root.right,node);
	      else if(node.val < root.val) root.left = dfs(root.left,node);
	      
	      return root;
	}
}
