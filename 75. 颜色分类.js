给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

 

示例 1：

输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]
示例 2：

输入：nums = [2,0,1]
输出：[0,1,2]
示例 3：

输入：nums = [0]
输出：[0]
示例 4：

输入：nums = [1]
输出：[1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-colors
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

这个题要注意 在循环中因为已经把数组第一项删除了 下面就不能再用 nums[i]进行判断了

/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function(nums) {
    let white = 0;
    let blue = 0;
    const len = nums.length;
    for (let i = 0 ; i < len ; i++) {
        const temp = nums[i];
        nums.splice(i, 1); //这里做了删除操作 下面的if判断不能再用nums[i]进行判断了
        if (temp === 0) {
            nums.unshift(temp);
            white++;
            blue++;
        }
        if (temp === 1) {
            nums.splice(white, 0, temp);
            blue++;
        }
        if (temp === 2) {
            nums.splice(blue, 0, temp);
        }
    }
    return nums;
};
