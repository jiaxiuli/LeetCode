On a plane there are n points with integer coordinates points[i] = [xi, yi]. Your task is to find the minimum time in seconds to visit all points.

You can move according to the next rules:

In one second always you can either move vertically, horizontally by one unit or diagonally (it means to move one unit vertically and one unit horizontally in one second).
You have to visit the points in the same order as they appear in the array.
 

Example 1:


Input: points = [[1,1],[3,4],[-1,0]]
Output: 7
Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]   
Time from [1,1] to [3,4] = 3 seconds 
Time from [3,4] to [-1,0] = 4 seconds
Total time = 7 seconds
Example 2:

Input: points = [[3,2],[-2,2]]
Output: 5

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0 ;
        for( int i = 0 ; i < points.length - 1 ; i++ ){
            sum = sum + find(points[i][0], points[i][1], points[i+1][0], points[i+1][1]);
        }
        return sum;
    }
    public int find(int x1, int y1, int x2, int y2){
        int count = 0 ;
        while(Math.abs(x2 - x1) != Math.abs(y2 - y1)){
            if(Math.abs(x2 - x1) < Math.abs(y2 - y1)){
                if(y2 > y1){
                    y2 = y2 - 1;
                    count++;
                    continue;
                }else if(y2 < y1){
                    y2 = y2 + 1;
                    count++;
                    continue;
                }  
            }
            if(Math.abs(x2 - x1) > Math.abs(y2 - y1)){
                 if(x2 > x1){
                    x2 = x2 - 1;
                    count++;
                    continue;
                }else if(x2 < x1){
                    x2 = x2 + 1;
                    count++;
                    continue;
                }  
            }
        }
        return count + Math.abs(x2 - x1);
    }
}
