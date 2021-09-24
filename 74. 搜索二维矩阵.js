编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。
 

示例 1：


输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
输出：true
示例 2：


输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
输出：false


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-a-2d-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

二分查找类似的题 取mid 需要取 (arr.length - 1) / 2
还需要单独处理一下 arr.length = 1 和 =0 的情况

/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    let arr = [];
    for (let i = 0 ; i < matrix.length ; i++) {
        arr = [...arr, ...matrix[i]];
    }
    return find(arr, target);
};

var find = function(arr, target) {
    if (arr.length === 0) return false;
    if (arr.length === 1) {
        return arr[0] === target;
    }
    const mid = Math.floor((arr.length - 1) / 2);
    if (arr[mid] === target) return true;
    if (arr[mid] < target) {
        return find (arr.slice(mid + 1), target);
    }
    if (arr[mid] > target) {
        return find (arr.slice(0, mid), target);
    }
}
