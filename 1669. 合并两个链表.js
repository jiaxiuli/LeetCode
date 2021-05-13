// 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。

// 请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。

// 下图中蓝色边和节点展示了操作后的结果：


// 请你返回结果链表的头指针。

 

// 示例 1：



// 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
// 输出：[0,1,2,1000000,1000001,1000002,5]
// 解释：我们删除 list1 中第三和第四个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
// 示例 2：


// 输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
// 输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
// 解释：上图中蓝色的边和节点为答案链表。

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/merge-in-between-linked-lists
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} list1
 * @param {number} a
 * @param {number} b
 * @param {ListNode} list2
 * @return {ListNode}
 */
var mergeInBetween = function(list1, a, b, list2) {
    var left = list1;
    var right = list1;
    var leftCount = 0;
    var rightCount = 0;
    var node = list2;
    while( leftCount < a - 1 ){
        left = left.next;
        leftCount++;
    }
    while( rightCount <= b  ){
        right = right.next;
        rightCount++;
    }
    while(node.next){
        node = node.next;
    }
    left.next = list2;
    node.next = right;
    return list1;

};
