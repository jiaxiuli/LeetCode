/*
Given an array of integers nums.

A pair (i,j) is called good if nums[i] == nums[j] and i < j.

Return the number of good pairs.

 

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
*/

class Solution {
    public int numIdenticalPairs(int[] nums) {
      int arr[] = new int[101];
        
      for( int i = 0 ; i < nums.length ; i++ ){
          arr[nums[i]]++;
      }
      int sum = 0;
      for( int i = 0 ; i < arr.length ; i++ ){
          if( arr[i] > 1 ){
              for( int j = arr[i] - 1 ; j > 0 ; j-- ){
                  sum = sum + j;
              }
          }
      }
        return sum;
        
    }
}
