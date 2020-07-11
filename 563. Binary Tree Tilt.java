/*
Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.

Example:
Input: 
         1
       /   \
      2     3
Output: 1
Explanation: 
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1
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
    static int count = 0;
	static List<Integer> list = new  ArrayList<Integer>();
    public int findTilt(TreeNode root) {
        count = 0;
	    list.clear();
        calculate(root);
        int res = 0;
        for( int i : list )
            res += i;
        return res;
    }
     public static void count(TreeNode root) {
		 if( root == null ) return;
		 count = count + root.val;
		 count(root.left);
		 count(root.right);
		 
		 return;
	 }
	 public static void calculate(TreeNode root) {
		 if(root == null) return;
		 
		 count = 0;
		 count(root.left);
		 int left = count;
		 count = 0;
		 count(root.right);
		 int right = count;
		 list.add(Math.abs(right-left));
		 
		 calculate(root.left);
		 calculate(root.right);
		 
	 }
}
