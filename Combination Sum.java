/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), 
find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int arr[] = candidates;
        String s = "";
        List<List<Integer>> list = new ArrayList<List<Integer>>();
		dfs(target, arr, 0, s, list);
		
        return list;
    }
    
     public static void dfs(int target,int[] arr,int sum,String s, List<List<Integer>> list){
		
			
		 if( sum == target ) {
		

			List<String> temp = Arrays.asList(s.split("/"));
			List<Integer> temp0 = new ArrayList<Integer>();
			
			for( String i : temp ) {
				temp0.add(Integer.valueOf(i));
			}
			Collections.sort(temp0);
			boolean b = true;
			for( int i = 0 ; i < list.size(); i++ ) {
				if( list.get(i).equals(temp0))
					b = false;
			}
			if(b)
				list.add(temp0);
			 
		 }
		 
		 if( sum < target ) {
			 for(int i : arr ) { 
				 
				 dfs( target, arr, sum + i , s + i + '/', list );
				 }
		 }
			 
		 
	}
}
