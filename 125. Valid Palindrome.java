Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

Solution 1:
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        Stack stack = new Stack();
        for( int i = 0 ; i < s.length() ; i++ ){
            if(Character.isLetterOrDigit( s.charAt(i) ))
                stack.push(s.charAt(i));
        }
        for( int i = 0 ; i < s.length() ; i++ ){
            if(Character.isLetterOrDigit( s.charAt(i) )){
                if( s.charAt(i) == (char)stack.peek()){
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }
}

Solution 2:
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length()-1;
        
        while( left <= right ){
            if(!Character.isLetterOrDigit( s.charAt(left))){
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit( s.charAt(right))){
                right--;
                continue;
            }
            if(s.charAt(left) != s.charAt(right))return false;
            else{left++; right--;}
        }
        return true;
    }
}
