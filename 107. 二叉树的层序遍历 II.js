// 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

// 例如：
// 给定二叉树 [3,9,20,null,null,15,7],

//     3
//    / \
//   9  20
//     /  \
//    15   7
// 返回其自底向上的层序遍历为：

// [
//   [15,7],
//   [9,20],
//   [3]
// ]

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
var levelOrderBottom = function(root) {
    var list = [];
    var depth = 0;
    list = searchTree(root, list, depth);
    return  list.reverse();

};

function searchTree(root, list, depth) {
    if(root === null) return list;
    if(!list[depth]) {
        list[depth] = [];
    }
    list[depth].push(root.val);
    depth++;
    list = searchTree(root.left, list, depth);
    list = searchTree(root.right, list, depth);
    return list;

}
