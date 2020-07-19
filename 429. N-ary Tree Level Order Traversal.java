/*
Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

 

Example 1:



Input: root = [1,null,3,2,4,null,5,6]
Output: [[1],[3,2,4],[5,6]]
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
         List<List<Integer>> list = new ArrayList<List<Integer>>();
         list = dfs(root, list, 1);
         return list;
    }
    
    public List<List<Integer>> dfs(Node root, List<List<Integer>> list, int level){
        if( root == null )return list;
        
        if( list.size() < level ){
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(root.val);
            list.add(temp);
        }else{
            list.get(level-1).add(root.val);
        }
        
        for( Node node : root.children ){
            dfs(node, list, level+1);
        }
       return list;
    }
}
