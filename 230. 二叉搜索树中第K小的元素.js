// 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。

 

// 示例 1：


// 输入：root = [3,1,4,null,2], k = 1
// 输出：1
// 示例 2：


// 输入：root = [5,3,6,2,4,null,null,1], k = 3
// 输出：3

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。\
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function(root, k) {
    if(root === null) return 0;

    var list = [];
    list = bfs(root, list);
    list.sort(function (a,b) {
            if (a < b ) {     
                return -1;
            }
            if (a > b ) {
                return 1;
            }
            // a must be equal to b
            return 0;
        });
    return list[k-1];
};

var bfs = function(root, list){
    if(root === null) return list;
    list.push(root.val);
    bfs(root.left, list);
    bfs(root.right, list);
    return list;
}
