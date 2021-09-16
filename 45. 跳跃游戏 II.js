给你一个非负整数数组 nums ，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

假设你总是可以到达数组的最后一个位置。

示例 1:

输入: nums = [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
示例 2:

输入: nums = [2,3,0,1,4]
输出: 2

/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function(nums) {
    if ( nums.length === 1 ) return 0;
    const dp = new Array(nums.length);
    dp[nums.length - 1] = 0;
    for(let i = nums.length - 2 ; i >= 0 ; i--) {
        if (nums[i] > 0) {
            dp[i] = getMin(dp, i + 1, i + nums[i]) + 1;
        } else {
            dp[i] = Number.MAX_SAFE_INTEGER;
        }
    }
    return dp[0];
};

var getMin = function (dp, start, end) {
    let min = Number.MAX_SAFE_INTEGER;
    for (let i = start; i <= end; i++) {
        if (i >= dp.length) {
            return min;
        }
        if (dp[i] < min) {
            min = dp[i];
        }
    }
    if (min == Number.MAX_SAFE_INTEGER) {
        // 如果返回 MAX，返回时再加1，会越界
        return Number.MAX_SAFE_INTEGER - 1;
    } else {
        return min;
    }
}
