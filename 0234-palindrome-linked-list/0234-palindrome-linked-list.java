/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        
        ListNode slowNode = head;
        ListNode fastNode = head;
        while(fastNode.next!=null && fastNode.next.next!=null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        
        slowNode.next = reverseList(slowNode.next);
        slowNode = slowNode.next;        
        ListNode node = head;
        while(slowNode!=null){
            if(slowNode.val!=node.val) return false;
            slowNode = slowNode.next;
            node=node.next;
        }
        
        return true;
    }
    
    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}