package com.geeks.ds.linkedlist;

import java.util.HashMap;

/**
 * Clone a linked list using a random pointer
 */
public class CloneLLUsingRandomPointer {

    public static void main(String[] args) {
        LNode head = new LNode(10);
        head.next = new LNode(5);
        head.next.next = new LNode(20);
        head.next.next.next = new LNode(15);
        head.next.next.next.next = new LNode(20);

        head.random = head.next.next;
        head.next.random = head.next.next.next;
        head.next.next.random = head;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next.next.next;

        System.out.print("Original list : \n");
        print(head);

        System.out.print("\nCloned list : \n");
        LNode cloned_list = clone(head);
        print(cloned_list);
    }

    public static LNode clone(LNode head) {
        LNode next;
        LNode temp;
        for (LNode curr = head; curr != null; ) {
            next = curr.next;
            curr.next = new LNode(curr.data);
            curr.next.next = next;
            curr = next;
        }
        for (LNode curr = head; curr != null; curr = curr.next.next) {
            curr.next.random = (curr.random != null) ? (curr.random.next) : null;
        }

        LNode original = head, copy = head.next;

        temp = copy;

        while (original != null && copy != null) {
            original.next =
                    original.next != null ? original.next.next : original.next;

            copy.next = copy.next != null ? copy.next.next : copy.next;
            original = original.next;
            copy = copy.next;
        }

        return temp;
    }


    public static void print(LNode start) {
        LNode ptr = start;
        while (ptr != null) {
            System.out.println("Data = " + ptr.data + ", Random  = " + ptr.random.data);
            ptr = ptr.next;
        }
    }

    // Clone linked using hashmap
    public static LNode clone1(LNode head) {
        HashMap<LNode, LNode> hm = new HashMap<LNode, LNode>();
        for (LNode curr = head; curr != null; curr = curr.next)
            hm.put(curr, new LNode(curr.data));

        for (LNode curr = head; curr != null; curr = curr.next) {
            LNode cloneCurr = hm.get(curr);
            cloneCurr.next = hm.get(curr.next);
            cloneCurr.random = hm.get(curr.random);
        }
        LNode head2 = hm.get(head);

        return head2;
    }
}

class LNode {
    int data;
    LNode next, random;

    LNode(int x) {
        data = x;
        next = random = null;
    }
}
