/*Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
Example 1:
Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3*/
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0 ; i < nums.length -1 ; i++ ){
            if(nums[i] == 0)continue;
            for(int j = i + 1 ; j < nums.length ; j++ ){
                if(nums[j] == 0)continue;
                int index = j + 1;
                while(index < nums.length && nums[index] < nums[i] + nums[j]){
                    if(nums[index] == 0)continue;
                    count++;
                    index++;
                }
                    
            }
        }
        return count;
    }
}
