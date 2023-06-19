/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        
        ListNode slowNode = head;
        ListNode fastNode = head;
        ListNode entryNode = head;
        
        while(fastNode.next!=null && fastNode.next.next!=null){
                slowNode = slowNode.next;
                fastNode = fastNode.next.next;
            if(slowNode==fastNode){
                while(slowNode!=entryNode){
                   slowNode=slowNode.next;
                   entryNode = entryNode.next;
                   
               } 
                return entryNode;
            }
               
            
            }
        return null;
    }
}