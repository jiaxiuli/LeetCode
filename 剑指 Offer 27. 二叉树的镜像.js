// 请完成一个函数，输入一个二叉树，该函数输出它的镜像。

// 例如输入：

//      4
//    /   \
//   2     7
//  / \   / \
// 1   3 6   9
// 镜像输出：

//      4
//    /   \
//   7     2
//  / \   / \
// 9   6 3   1

 

// 示例 1：

// 输入：root = [4,2,7,1,3,6,9]
// 输出：[4,7,2,9,6,3,1]

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
var mirrorTree = function(root) {
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
