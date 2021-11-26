将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
 

示例 1：

输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"
示例 2：
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I
示例 3：

输入：s = "A", numRows = 1
输出："A"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zigzag-conversion
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function(s, numRows) {
    if (s.length <= numRows || numRows === 1) return s;
    let res = [];
    let mark = numRows - 2;
    let temp = [];
    for (let i = 0 ; i < s.length ; i++) {
        if (temp.length < numRows) {
            temp.push(s[i]);
            if (temp.length === numRows) {
                res.push(temp);
            }
        } else {
            if (mark > 0) {
                temp = new Array(numRows);
                temp[mark] = s[i];
                res.push(temp);
                mark--;
                if (mark === 0) {
                    temp = [];
                    mark = numRows - 2;
                }
            } else {
                temp = [];
                temp.push(s[i]);
            }
        }
    }
    if (temp.length > 0 && temp.length < numRows)
        res.push(temp);
    let s0 = '';
    for (let i = 0 ; i < res[0].length ; i++) {
        for (let j = 0 ; j < res.length ; j++) {
            if (res[j][i]) {
                s0 += res[j][i];
            }
        }
    }
    return s0;
};
