// 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

 

// 示例 1：

// 输入：s = "We are happy."
// 输出："We%20are%20happy."

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
var replaceSpace = function(s) {
    for(var i = 0 ; i < s.length ; i++ ){
        if(s[i] === ' '){
            var s0 = s.substring(0, i) + '%20' + s.substring(i+1, s.length);
            s = s0;
        }
    }
    return s;
};
