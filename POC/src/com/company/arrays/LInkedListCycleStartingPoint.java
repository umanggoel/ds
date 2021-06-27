package com.company.arrays;

public class LInkedListCycleStartingPoint {

    public ListNode detectCycle(ListNode head) {

        if(head == null) return head;

        ListNode p1 = head;
        ListNode p2 = head;
        int flag =0;

        while(p1 != null && p2!=null && p2.next != null){
            p1= p1.next;
            p2 = p2.next.next;
            if(p1 == p2 ){
                flag = 1;
                break;
            }
        }

        if(flag == 1){
            p1 = head;
            while( p1 != p2){
                p1 = p1.next;
                p2 = p2.next;
            }

            return p1;
        }

        return null;
    }
}
