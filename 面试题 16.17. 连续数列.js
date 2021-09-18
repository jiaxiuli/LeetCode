给定一个整数数组，找出总和最大的连续数列，并返回总和。

示例：

输入： [-2,1,-3,4,-1,2,1,-5,4]
输出： 6
解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/contiguous-sequence-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    if (nums.length === 0) return 0;
    const n = nums.length;
    const dp = new Array(n);
    dp[0] = nums[0];
    for (let i = 1; i < n ; i++) {
        dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
    }

    return Math.max(...dp);
};
