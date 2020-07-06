/*Given two positive integers n and k.

A factor of an integer n is defined as an integer i where n % i == 0.

Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or return -1 if n has less than k factors.
Example 1:

Input: n = 12, k = 3
Output: 3
Explanation: Factors list is [1, 2, 3, 4, 6, 12], the 3rd factor is 3.
*/

class Solution {
    public int kthFactor(int n, int k) {
      List<Integer> list = new ArrayList<Integer>();
        
        for( int i = 1 ; i  <= n ; i++ ){
            if( n % i == 0 ){
               list.add(i);
            }
        }
       if( list.size() < k )
           return -1;
        else
            return list.get(k-1);
    }
}
