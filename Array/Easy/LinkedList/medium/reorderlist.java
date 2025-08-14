import java.util.*;

class main {
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int x) {
            data = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        ListNode head = arrtoll(nums);
        ListNode result =reorderList(head);
        ListNode temp = result;
        while (temp!= null){
            System.out.print(temp.data+ " ");
            temp= temp.next;
        }

    }

    public static ListNode arrtoll(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        ListNode head = new ListNode(nums[0]);
        ListNode curr = head; // this is a ListNode pointer
        for (int i = 1; i < nums.length; i++) {
            curr.next = new ListNode(nums[i]);
            curr = curr.next;

        }
        return head;
    }

    public static ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        // now we will be splitting the ListNode into two parts

        ListNode fast = head;
        ListNode slow = head;
        // these are two node pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }

        // now we will be wrtiting the reverse of a linked list here


        ListNode prev= null;
        ListNode curr= slow;
        ListNode next; // we have defined this fro the time being
        while (curr!= null){
            next =curr.next;
            curr.next= prev;
            prev= curr;
            curr= next;
        }


        // now we have to merge the two arrays
        ListNode first = head;
        ListNode second = prev;
        while (second.next!= null) { //  which is basicall the end of the list is what they are trying to say
            ListNode temp1= first.next;
            ListNode temp2= second.next;
            first.next= second;
            second.next=temp1;
            first= temp1;
            second = temp2;

        } 

        return head;
    }

}