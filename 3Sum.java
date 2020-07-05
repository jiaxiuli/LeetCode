class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      
		Arrays.sort(nums);
		
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(nums.length < 3) {
			return list;
		}
		
		for( int i = 0 ; i < nums.length ; i++) {
			int l = i+1;
			int r = nums.length - 1;
			
			while( l < r) {
				
                if(nums[i] + nums[l] + nums[r] == 0) {
					ArrayList<Integer> templist = new ArrayList<Integer>();
					templist.add(nums[i]);
					templist.add(nums[l]);
					templist.add(nums[r]);
		            list.add(templist);
		                
					l++;
					r--;
                    while(l<r && nums[l]==nums[l-1]) l++;
	                 while(l<r && nums[r]==nums[r+1]) r--;
				
				}else if(nums[l] + nums[r] < 0 - nums[i]) {
					l++;
					
				}else {
					r--;
				
				}
				
			}
			 while(i< nums.length-1 && nums[i]== nums[i+1])
	             i++;
		}
// 		List tempList = new ArrayList();
//         for(int i=0;i<list.size();i++){
//             if(!tempList.contains(list.get(i)))
//                 tempList.add(list.get(i));
//         }
		
		return list;
    }
}
