import java.util.*;

class main {
    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int m = sc.nextInt(); // this is the mth node from the back
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        Node head = arrtoll(nums);
        Node result = removenthNode(head, m);
        Node temp = result;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node arrtoll(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        Node head = new Node(nums[0]);
        Node curr = head; // this is like a node pointer

        for (int i = 1; i < nums.length; i++) {
            curr.next = new Node(nums[i]);
            curr = curr.next;
        }
        return head;
    }

    public static Node removenthNode(Node head, int m) {
        Node fast = head;
        Node slow = head;
        for (int i = 0; i < m; i++) {
            fast = fast.next;
        }
        // edge case
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next; // we will create this bond
        return head;
    }

}