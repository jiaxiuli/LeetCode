/*
Given a m * n matrix mat of integers, sort it diagonally in ascending order from the top-left to the bottom-right then return the sorted array.

 

Example 1:


Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
*/

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat[0].length;
        int m = mat.length;
        for( int i = m - 1 ; i >= 0 ; i-- ){
            int x = i, y = 0;
            List<Integer> list = new ArrayList<Integer>();
            
            while( x < m && y < n ){
                list.add(mat[x][y]);
                x++;
                y++;
            }
            Collections.sort(list);
            x = i;
            y = 0;
            int index = 0;
            while(x < m && y < n){
                mat[x][y] = list.get(index);
                index++;
                x++;
                y++;
            }
        }
        for( int i = 0 ; i < n ; i++ ){
            int x = 0, y = i;
            List<Integer> list = new ArrayList<Integer>();
            
            while( x < m && y < n ){
                list.add(mat[x][y]);
                x++;
                y++;
            }
            Collections.sort(list);
            x = 0;
            y = i;
            int index = 0;
            while(x < m && y < n){
                mat[x][y] = list.get(index);
                index++;
                x++;
                y++;
            }
        }
        return mat;
    }
}
