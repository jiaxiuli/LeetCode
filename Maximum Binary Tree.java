/*
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.
Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
递归循环，第一步找出数组中最大的数，当作root，然后递归，把左面的数组拿去构建左子树，重复这个过程，右面的数组拿去构建右子树。        
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = dfs(nums);
        return root;
    }
    
    public TreeNode dfs(int[] nums){
        if( nums.length == 0 )return null;
        //find max
        int max = 0;
        int index = 0;
        for( int i = 0 ; i < nums.length ; i++ ){
            if( nums[i] > max ){
                max = nums[i]; 
                index = i;
            }
                
        }
        TreeNode node = new TreeNode(max);
        node.left = dfs(Arrays.copyOfRange(nums, 0, index));
        node.right = dfs(Arrays.copyOfRange(nums, index+1, nums.length));
        
        return node;
    }
}
