/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/
/*使用回溯的思想，尝试添加下一个（或）， 但是有两个条件。如果左括号剩下的个数大于0，优先添加左括号。
只有在有括号剩下的个数比左括号剩下的个数多的情况下，才添加右括号，用一个递归就可以了
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        dfs(n,n,"",list);
        return list;
    }
    
    public void dfs(int leftremain,int rightremain,String str,List<String> list){
        if( leftremain == 0 && rightremain == 0 ){
            list.add(str);
        }
        
        if( leftremain > 0 )
            dfs(leftremain - 1, rightremain, str+"(",list);
        if( leftremain < rightremain )
            dfs( leftremain, rightremain - 1, str+")",list);
    }
}
