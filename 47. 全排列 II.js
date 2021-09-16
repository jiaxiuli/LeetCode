给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

 

示例 1：

输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
示例 2：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

提示：

1 <= nums.length <= 8
-10 <= nums[i] <= 10


/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
    if (nums.length < 2) return [nums];
    return getPermuteUnique(nums);
};
var getPermuteUnique = function(nums) {
    if (nums.length === 2) {
        if (nums[0] !== nums[1])
            return [[nums[0], nums[1]], [nums[1], nums[0]]];
        else
            return [[nums[0], nums[1]]];
    }
    let res = [];
    const repeat = [];
    for ( let i = 0 ; i < nums.length ; i++ ) {
        if (repeat.indexOf(nums[i]) === -1) {
            const temp = getPermuteUnique(nums.slice(0, i).concat(nums.slice(i + 1)));
            const tempRes = temp.map((item) => {
                item.unshift(nums[i]);
                return item;
            });
            res = res.concat(tempRes);
            repeat.push(nums[i]);
        }
    }
    return res;
}
