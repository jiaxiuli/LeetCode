/*Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 

Follow up: Solve it both recursively and iteratively.*/

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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        
        List list_left = new ArrayList();
        List list_right = new ArrayList();
        list_left = dfsLeft(root.left, list_left);
        list_right = dfsRight(root.right, list_right);
        String s1 = "", s2 = "";
        for( int i = 0 ; i < list_left.size() ; i++ ){
            s1 = s1 + list_left.get(i);
        }
        for( int i = 0 ; i < list_right.size() ; i++ ){
            s2 = s2 + list_right.get(i);
        }
        System.out.println(s1);
        System.out.println(s2);
        
        return s1.equals(s2);
    }
    public List dfsLeft(TreeNode root, List list){
        if( root == null ){
            list.add(-1);
            return list;
        }
        list.add(root.val);
        dfsLeft(root.left, list);
        dfsLeft(root.right, list);
        return list;
    }
      public List dfsRight(TreeNode root, List list){
        if( root == null ){
            list.add(-1);
            return list;
        }
        list.add(root.val);
        dfsRight(root.right, list);
        dfsRight(root.left, list);
        return list;
    }
}
