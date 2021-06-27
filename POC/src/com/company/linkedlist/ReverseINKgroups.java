package com.company.linkedlist;

public class ReverseINKgroups {

    public static void main(String[] args) {
        ReverseINKgroups reverseINKgroups = new ReverseINKgroups();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

       // reverseINKgroups.reverseKGroup(n1, 3);
        reverseINKgroups.reverseList(n1);

    }
    public ListNode reverseKGroup(ListNode head, int k) {

        int count = 1;
        ListNode p = head;
        ListNode result = new ListNode(0);
        ListNode r = result;
        while(p.next != null) {
            count++;
            p = p.next;
        }

        ListNode start = head;
        int rc = 0;
        p = head;
        ListNode next = head;
        while(count >= k ){
            ListNode temp = result.next;
            ListNode temp2 = p.next;
            result.next = p;
            p.next = temp;
            p = temp2;
            rc++;
            if(rc == k){
                count = count-k;
                rc = 0;
                result = next;
                next = p;
            }
        }

        if(count != 0) {
            result.next = p;
        }
        return r.next;
    }

    ListNode reverseList(ListNode head) {
        ListNode node = new ListNode();
        while(head != null) {
            ListNode t2 = head.next;
            head.next = node.next;
            node.next = head;
            head = t2;
        }
        ListNode temp = node;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
        return node.next;
    }
}
