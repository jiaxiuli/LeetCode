给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

进阶：

你可以设计一个只使用常数额外空间的算法来解决此问题吗？
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 

示例 1：


输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]
示例 2：


输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]
示例 3：

输入：head = [1,2,3,4,5], k = 1
输出：[1,2,3,4,5]
示例 4：

输入：head = [1], k = 1
输出：[1]

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var reverseKGroup = function(head, k) {
    let len = getLength(head);
    if (getLength(head) < k) return head;
    
    let left = head;
    let right = head.next;
    for (let i = 0 ; i < k - 1 ; i++) {
        left = left.next;
        right = right.next;
    }
    let reversedRest = reverseKGroup(right, k);

    left.next = null;
    let reversedHead = reverse(head, k);
    let fake = reversedHead;
    while (fake.next !== null) {
        fake = fake.next;
    }
    fake.next = reversedRest;
    return reversedHead;
};

function getLength (head) {
    let len = 0;
    while(head !== null) {
        head = head.next;
        len++;
    }
    return len;
}

function reverse (listNode, len) {
    if (len === 0) return null;
    if (len === 1) return listNode;
    if (len === 2) {
        let temp = listNode.next;
        listNode.next.next = listNode;
        listNode.next = null;
        return temp;
    }
    let res = reverse(listNode.next, len - 1);
    let temp = res;
    while (temp.next !== null) temp = temp.next;
    temp.next = listNode;
    listNode.next = null;
    return res;
}
