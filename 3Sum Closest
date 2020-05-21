class Solution {
    public int threeSumClosest(int[] nums, int target) {
   //     int nums[] = new int[] {-1, 2, 1, -4};
		Arrays.sort(nums);
	//	int target = 1;
		int closest = 99999;
		int result = 0;
		for( int i = 0 ; i < nums.length ; i++) {
			
			int l = i + 1;
			int r = nums.length - 1;
			
			
			while( l < r) {
				int sum = nums[i] + nums[l] + nums[r];
				if(Math.abs( sum - target )  < closest) {
					closest = Math.abs( sum - target ) ;
					result = sum;
				//	System.out.println(nums[i] +"   "+ nums[l] +"    "+ nums[r]);
				}
					if(sum < target) {
				//		System.out.println("l = "+l);
						l++;
					
						
					}else if(sum > target) {
				//		System.out.println("r = "+r);
						r--;
						
					}else {
						
						break;
					}
				
				
				
				
			}
			if( closest == 0) {
				break;
			}
			
			
		}
		
		
	return result;
    }
}
