在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

 

示例 1：

输入：nums = [3,4,3,3]
输出：4
示例 2：

输入：nums = [9,1,7,9,7,9,7]
输出：1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    nums.sort((a, b) => {return a-b;});
    var res = 0;
    if(nums[0] != nums[1]) return nums[0];
    for(var i = 1 ; i < nums.length ; i++ ){
        if( i < nums.length - 1){
            if( nums[i-1] != nums[i] && nums[i + 1] != nums[i] ){
                res = nums[i];
            }
        } else {
            if(nums[i-1] != nums[i]){
                res = nums[i];
            }
        }
   }
   return res;
};
