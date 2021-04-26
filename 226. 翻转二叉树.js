// 翻转一棵二叉树。

// 示例：

// 输入：

//      4
//    /   \
//   2     7
//  / \   / \
// 1   3 6   9
// 输出：

//      4
//    /   \
//   7     2
//  / \   / \
// 9   6 3   1

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/invert-binary-tree
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
var invertTree = function(root) {
  if(root === null) return root;
    var head = new TreeNode(root.val);
    head = reverseTree(head, root);
    return head;
};
function reverseTree(head, root) {
    if( root === null ) return head;
    if( head === null ) {
        head = new TreeNode(root.val);
    }
    head.right = reverseTree(head.right, root.left);
    head.left = reverseTree(head.left, root.right);
    return head;
}
