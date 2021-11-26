实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须 原地 修改，只允许使用额外常数空间。

 

示例 1：

输入：nums = [1,2,3]
输出：[1,3,2]
示例 2：

输入：nums = [3,2,1]
输出：[1,2,3]
示例 3：

输入：nums = [1,1,5]
输出：[1,5,1]
示例 4：

输入：nums = [1]
输出：[1]
 

提示：

1 <= nums.length <= 100
0 <= nums[i] <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


倒着查找 设数组最后一项是right 倒数第二项是left 
当遇到第一个nums[left] > nums[right]的时候 
将从right开始 到 数组末尾的这一段排序 
然后再从right开始 向后找到第一个比nums[left]大的数 和nums[left]交换位置即可

/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var nextPermutation = function(nums) {
    let left = nums.length - 2;
    let right = nums.length - 1;

    while (left >= 0) {
        if (nums[left] < nums[right]) {
           // 给从right开始的数排序
           for (let i = 0 ; i < nums.length - right ; i++) {
                let l = right;
                let r = right + 1;
                while (r < nums.length) {
                    if (nums[l] > nums[r]) {
                        let temp = nums[l];
                        nums[l] = nums[r];
                        nums[r] = temp;
                    }
                    l++;
                    r++;
                }
           }
           // 找到第一个比nums[left]大的数
           for (let i = right ; i < nums.length ; i++) {
               if (nums[i] > nums[left]) {
                   let temp = nums[left];
                   nums[left] = nums[i];
                   nums[i] = temp;
                   break;
               }
           }
            return nums;
        } else {
            left--;
            right--;
        }
    }
    return nums.sort((a, b) => a - b );
};
