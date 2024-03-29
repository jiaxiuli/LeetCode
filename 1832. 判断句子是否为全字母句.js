// 全字母句 指包含英语字母表中每个字母至少一次的句子。

// 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。

// 如果是，返回 true ；否则，返回 false 。

 

// 示例 1：

// 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
// 输出：true
// 解释：sentence 包含英语字母表中每个字母至少一次。
// 示例 2：

// 输入：sentence = "leetcode"
// 输出：false

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/check-if-the-sentence-is-pangram
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

/**
 * @param {string} sentence
 * @return {boolean}
 */
var checkIfPangram = function(sentence) {
   var num = 'a'.charCodeAt(0);
   var letters = [];
   for(var i = 97 ; i < 26 + 97 ; i++ ){
       letters.push(i);
   }
   for(var i = 0 ; i < letters.length ; i++ ){
       var b = false;
       for( var j = 0 ; j < sentence.length ; j++ ){
           if(letters[i] === sentence.charCodeAt(j)){
               b = true;
               break;
           }
       }
       if(!b){
           return false;
       }
   }
   return true;
};
