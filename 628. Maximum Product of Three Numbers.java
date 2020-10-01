/*
Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:

Input: [1,2,3]
Output: 6
 

Example 2:

Input: [1,2,3,4]
Output: 24
*/

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length-1;
        int a = nums[n] * nums[n-1] * nums[n-2];
        int b = nums[0] * nums[1] * nums[n];
        if( a > b )return a;
        else return b;
    }
}
