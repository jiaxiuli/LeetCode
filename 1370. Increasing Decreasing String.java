/*
Given a string s. You should re-order the string using the following algorithm:

Pick the smallest character from s and append it to the result.
Pick the smallest character from s which is greater than the last appended character to the result and append it.
Repeat step 2 until you cannot pick more characters.
Pick the largest character from s and append it to the result.
Pick the largest character from s which is smaller than the last appended character to the result and append it.
Repeat step 5 until you cannot pick more characters.
Repeat the steps from 1 to 6 until you pick all characters from s.
In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.

Return the result string after sorting s with this algorithm.

 

Example 1:

Input: s = "aaaabbbbcccc"
Output: "abccbaabccba"
Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
After steps 4, 5 and 6 of the first iteration, result = "abccba"
First iteration is done. Now s = "aabbcc" and we go back to step 1
After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"
*/

class Solution {
    public String sortString(String s) {
      String s0 = "";
		
		while(s.length() > 0) {
		int index = 0;
		char min = 123;
		char max = 96;
		char lastMin = 96;
		char lastMax = 123;
		
		boolean flag = true;
		
		while(flag) {
			flag = false;
			for(int i = 0 ; i < s.length(); i++ ) {
				if(s.charAt(i) < min && s.charAt(i) > lastMin) {
					min = s.charAt(i);
					index = i;
					flag = true;
				}
			}
			if(flag) {
				s = remove(s, index);
				lastMin = min;
				s0 = s0 + min;
				min = 123;
			}
			
			
		}
		flag = true;
		while(flag) {
			flag = false;
			for(int i = 0 ; i < s.length(); i++ ) {
				if(s.charAt(i) > max && s.charAt(i) < lastMax) {
					max = s.charAt(i);
					index = i;
					flag = true;
				}
			}
			if(flag) {
				s = remove(s, index);
				lastMax = max;
				s0 = s0 + max;
				max = 96;
			}
			
			
		}
		
		}
		
		
		return s0;
    }
    public String remove(String s, int index) {
		String s0 = "";
		for(int i = 0 ; i < s.length(); i++ ) {
			if(i == index)
				continue;
			else
				s0 = s0 + s.charAt(i);
		}
		return s0;
	}
    
}
