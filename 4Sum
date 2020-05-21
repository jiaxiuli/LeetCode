class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    //    int nums[] = new int[] {1, 0, -1, 0, -2, 2};
		Arrays.sort(nums);
	//	int target = 0 ;
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		for( int i = 0 ; i < nums.length - 3 ; i++) {
			for( int j = i + 1 ; j < nums.length - 2 ; j++) {
				int l = j + 1 ;
				int r = nums.length - 1;
				
				while( l < r) {
					if( nums[i] + nums[j] + nums[l] + nums[r] == target) {
						ArrayList<Integer> templist = new ArrayList<Integer>();
						templist.add(nums[i]);
						templist.add(nums[j]);
						templist.add(nums[l]);
						templist.add(nums[r]);
			            list.add(templist);
			            l++;
			            r--;
			            while(l<r && nums[l]==nums[l-1]) l++;
		                 while(l<r && nums[r]==nums[r+1]) r--;
					}else if(nums[i] + nums[j] + nums[l] + nums[r] < target) {
						l++;
					}else {
						r--;
					}
				
				}
				while(j < nums.length-2 && nums[j]== nums[j+1])
		             j++;
			
			}
			while(i < nums.length-3 && nums[i]== nums[i+1])
	             i++;
		}
		//System.out.println(list);
        return list;
    }
}
