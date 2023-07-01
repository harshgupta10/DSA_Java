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
    public ListNode rotateRight(ListNode head, int k) {
         if(head==null)
            return head;
        else if(head.next==null)
            return head;
        ListNode node1 =head;
        ListNode node2=head.next;
       
        int len=0;
        ListNode temp=head;
        while(temp!=null)
        {
            len++;
            temp=temp.next;
        }
        k=k%len;
        for(int i=0;i<k;i++){
           while(node2.next!=null){
               node1=node2;
               node2=node2.next;
           }
            node2.next=head;
            node1.next=null;
            head=node2;
        }
        return head;
    }
}