// 给定一个二叉树，在树的最后一行找到最左边的值。

// 示例 1:

// 输入:

//     2
//    / \
//   1   3

// 输出:
// 1
 

// 示例 2:

// 输入:

//         1
//        / \
//       2   3
//      /   / \
//     4   5   6
//        /
//       7

// 输出:
// 7

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
var findBottomLeftValue = function(root) {
    var depth = 0;

    // list[0]表示左下角的值 list[1]表示最大深度
    var list = [0, 0]
    list = searchTree(root, depth, list);
    return list[0];
};

function searchTree(root, depth, list) {
    if(root === null) return list;
    depth++;
    // 当当前深度大于储存的最大深度时，赋值给左下角的值
    // 因为是先序遍历，所以第一次出现最大深度时的值就是最左边的
    // 以后如果没有更大的深度 那么它就是最左边的值
    // 因为这里的if写的是 > 号，当深度=这个最大深度的时候，值并不会被替换
    if( depth > list[1] ){
        list[1] = depth;
        list[0] = root.val;
    }
    list = searchTree(root.left, depth, list);
    list = searchTree(root.right, depth, list);
    return list;
}
