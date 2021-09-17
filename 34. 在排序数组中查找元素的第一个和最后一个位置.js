给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。

进阶：

你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 

示例 1：

输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
示例 2：

输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
示例 3：

输入：nums = [], target = 0
输出：[-1,-1]

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    let start = -1;
    let end = -1;
    for ( let i = 0 ; i < nums.length ; i++ ) {
        if (nums[0] === target) {
            start = 0;
        } else if (nums[i-1] < target && nums[i] === target) {
            start = i;
        }
        if (nums[nums.length - 1] === target) {
            end = nums.length - 1;
        } else if (nums[i] === target && nums[i+1] > target) {
            end = i;
        }
    }
    return [start, end];
};
