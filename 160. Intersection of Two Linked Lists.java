Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


begin to intersect at node c1.

 

Example 1:


Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 

Example 2:


Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Reference of the node with value = 2
Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 

Example 3:


Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: null
Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int lengthA = 0;
        int lengthB = 0;
        while(temp1 != null){
            lengthA++;
            temp1 = temp1.next;
        }
          while(temp2 != null){
            lengthB++;
            temp2 = temp2.next;
        }
        int diff;
        temp1 = headA;
        temp2 = headB;
        if(lengthA < lengthB){
            diff = lengthB - lengthA;
            for(int i = 0 ; i < diff ; i++ ){
                temp2 = temp2.next;
            }
        }else if(lengthB < lengthA){
             diff = lengthA - lengthB;
            for(int i = 0 ; i < diff ; i++ ){
                temp1 = temp1.next;
            }
        }
        while(temp1 != null && temp2 != null){
            if(temp1 == temp2)return temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
    }
}
