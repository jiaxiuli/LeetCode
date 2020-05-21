class Solution {
    public String addBinary(String a, String b) {
    String s1 = a, s2 = b;
        String c1 = "";
		 int count = 0;
		 if(s1.length() < s2.length()) {
			 String s = s1;
			 s1 = s2;
			 s2 = s;
		 }
		int m = s1.length() - s2.length();
		
		 for(int i = 0 ; i < m; i++) {
			 s2 = "0" + s2;
			
		 }
	
		for( int i = s1.length()-1 ; i >= 0 ; i--) {
			int sum = 0;
			sum = ( Integer.parseInt(String.valueOf(s1.charAt(i))) + Integer.parseInt(String.valueOf(s2.charAt(i))) + count )%2;
			
			count = (Integer.parseInt(String.valueOf(s1.charAt(i))) + Integer.parseInt(String.valueOf(s2.charAt(i)))+ count)/2;
			
			c1 = String.valueOf(sum) + c1;
			
		}
		if(count == 0){
            return c1;
        }else
        
        
        return  String.valueOf(count) + c1;
		
		
	
		
		
		
    }
}
