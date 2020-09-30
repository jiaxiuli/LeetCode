/*
Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

 

Example 1:


Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.
*/

class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int i = 0;
        while( i < mat.length ){
            sum = sum + mat[i][i];
            i++;
        }
        int j = mat.length - 1;
        i = 0;
        while( j >= 0 ){
            if( i == j ){
                i++;
                j--;
                continue;
            }
            sum = sum + mat[i][j];
            i++;
            j--;
        }
        return sum;
    }
}
