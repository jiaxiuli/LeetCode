给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

叶子节点 是指没有子节点的节点。

 

示例 1：


输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：[[5,4,11,2],[5,8,4,5]]
示例 2：


输入：root = [1,2,3], targetSum = 5
输出：[]
示例 3：

输入：root = [1,2], targetSum = 0
输出：[]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

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
 * @param {number} targetSum
 * @return {number[][]}
 */
var pathSum = function(root, targetSum) {
    if (root === null) return [];
    if (root.left === null && root.right === null) {
        if (root.val === targetSum) return [[root.val]];
        else return [];
    }
    let resLeft = dfs(root.left, targetSum - root.val, [root.val], []);
    let resRight = dfs(root.right, targetSum - root.val, [root.val], []);
  
    return [...resLeft, ...resRight];
};

var dfs = function (root, targetSum, path, res) {
    if (root !== null && root.left === null && root.right === null && targetSum === root.val) {
        path.push(root.val);
        res.push(path);
        return res;
    }
    if (root === null) {
        return [];
    }
    let resLeft = dfs(root.left, targetSum - root.val, [...path, root.val], []);
    let resRight = dfs(root.right, targetSum - root.val, [...path, root.val], []);
    return [...resLeft, ...resRight];
}
