// 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。

// 示例 1:

// 输入: 
// 	Tree 1                     Tree 2                  
//           1                         2                             
//          / \                       / \                            
//         3   2                     1   3                        
//        /                           \   \                      
//       5                             4   7                  
// 输出: 
// 合并后的树:
// 	     3
// 	    / \
// 	   4   5
// 	  / \   \ 
// 	 5   4   7
// 注意: 合并必须从两个树的根节点开始。

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
var mergeTrees = function(root1, root2) {

    return bfs(root1, root2);
};

function bfs(root1, root2) {
    if(root1 === null && root2 === null) return root1;
    if(root1 === null){
        root1 = new TreeNode(root2.val);
    } else if(root2 === null){
        root2 = new TreeNode(root1.val);
    } else {
        root1.val += root2.val;
    }
    root1.left = bfs(root1.left, root2.left);
    root1.right = bfs(root1.right, root2.right);

    return root1;
}
