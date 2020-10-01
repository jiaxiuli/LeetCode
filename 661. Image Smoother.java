/*
Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.

Example 1:
Input:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
Output:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
Explanation:
For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
*/

class Solution {
    public int[][] imageSmoother(int[][] M) {
        int arr[][] = new int[M.length][M[0].length];
        for( int i = 0 ; i < M.length ; i++ ){
            for( int j = 0 ; j < M[i].length ; j++ ){
                int arrX[] = new int[]{i-1, i , i+1};
                int arrY[] = new int[]{j-1, j , j+1};
                int count = 0;
                int sum = 0;
                for(int m = 0 ; m < 3 ; m++ ){
                    for( int n = 0 ; n < 3 ; n++ ){
                        if(arrX[m] < 0 || arrX[m] >= M.length || arrY[n] < 0 || arrY[n] >= M[i].length)continue;
                        else{
                            sum += M[arrX[m]][arrY[n]];
                            count++;
                        }
                    }
                }
                arr[i][j] = sum/count;
                
            }
        }
        return arr;
    }
}
