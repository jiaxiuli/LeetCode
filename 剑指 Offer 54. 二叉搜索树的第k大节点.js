// 给定一棵二叉搜索树，请找出其中第k大的节点。

 

// 示例 1:

// 输入: root = [3,1,4,null,2], k = 1
//    3
//   / \
//  1   4
//   \
//    2
// 输出: 4
// 示例 2:

// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//        5
//       / \
//      3   6
//     / \
//    2   4
//   /
//  1
// 输出: 4

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
var kthLargest = function(root, k) {
    var list = [];
    list = searchTree(root, list);
    return list[list.length - k];
};

function searchTree(root, list) {
    if(root === null) return list;
    list = searchTree(root.left, list);
    list.push(root.val);
    list = searchTree(root.right, list);
    return list;
}
