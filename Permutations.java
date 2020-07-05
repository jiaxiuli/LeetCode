/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
回溯法，如果后面使用的数字不能重复，就每次迭代的时候更改数组，把除自己之外的剩余元素传给下一次。
*/




class Solution {
    public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> list = new ArrayList<List<Integer>>();
		String s = "";
	        dfs(nums.length, nums, s, list);
        return list;
    }
    
  public static void dfs(int remain, int[] nums, String s, List<List<Integer>> list){
	        if( remain == 0 ){
	        
				List<String> temp = Arrays.asList(s.split("/"));
				List<Integer> temp0 = new ArrayList<Integer>();
				for( String i : temp ) {
					temp0.add(Integer.valueOf(i));
				}
				list.add(temp0);
	            return;
	        }
	        
	        if( remain > 0 ){
	            for( int i = 0 ; i < nums.length ; i++ ){
	            
	                dfs( remain - 1, changeArr(nums, i), s + nums[i] + '/' , list);
	            }
	        }
	        
	    }
	 public static int[] changeArr(int[] arr, int index) {
		 int arr0[] = new int[arr.length-1];
		 int p = 0;
		 for( int i = 0 ; i < arr.length ; i++ ) {
			 if( i != index ) {
				 arr0[p] = arr[i];
				 p++;
			 }
				
		 }
		 return arr0;
	 }

}
