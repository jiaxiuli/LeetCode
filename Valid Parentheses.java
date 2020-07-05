/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.*/
/*
首先应该判断字符串长度是否为偶数，奇数肯定不能完全配对。
利用stack去判断，如果是(, [, {, 就放入栈中，当遇到不是这三个的时候，栈顶的元素必须可以配对。如果配对就删除栈顶的元素，如果可以全部配对，最后栈应该为空。
因为判断过是偶数，所以当有一个不匹配的时候，肯定有某个元素没有被删掉，因为总数是偶数，有一步没有被删掉后面也就删不掉了。
利用Java Stack类
Stack<Character> stack = new Stack();

stack类的方法：
stack.isEmpty() 判断栈是否为空
stack.pop() 删除顶部元素，不需要参数
stack.push(c) 把c压入栈
stack.peek() 查看顶部元素，不删除
*/

class Solution {
    public boolean isValid(String s) {
        if ( s.length() % 2 != 0 ) return false;
        
        Stack<Character> stack = new Stack();
        for( char c : s.toCharArray()){
            
            if( c == '(' || c == '[' || c == '{' ){
                stack.push(c);
            }else if( c == ')' && !stack.isEmpty() && stack.peek() == '(' )
                stack.pop();
            else if(c == ']' && !stack.isEmpty() && stack.peek() == '[')
                 stack.pop();
             else if(c == '}' && !stack.isEmpty() && stack.peek() == '{')
                 stack.pop();
        }
        return stack.isEmpty();
    }
}
