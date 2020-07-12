/*
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time.

Return that integer.

 

Example 1:

Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6
*/
class Solution {
    public int findSpecialInteger(int[] arr) {
        int left = 0, right = 1;
        if( arr.length < 2 )return arr[0];
        
        while( right < arr.length ){
            if( arr[left] == arr[right] ){
                if( (right - left)+1 > arr.length/4 )
                    return arr[right];
                 right++;
            }else{
                left = right;
                right++;
            }
        }
        return 0;
    }
}
