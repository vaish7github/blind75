// Validate Binary Search Tree

import java.util.*;

class Main {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            data = x;
            left = null;
            right = null;
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

        TreeNode head = arrtotree(nums);
        boolean result =isValidBST(head);
        System.out.println(result);
    }

    public static TreeNode arrtotree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(head);
        int i = 1;

        while (!queue.isEmpty() && i < nums.length) {
            TreeNode curr = queue.poll();

            if (i < nums.length) {

                curr.left = new TreeNode(nums[i++]);
                queue.offer(curr.left);
            }

            if (i < nums.length) {
                curr.right = new TreeNode(nums[i++]);
                queue.offer(curr.right);
            }
        }
        return head;
    }


    public static Boolean isValidBST(TreeNode head){
        return validate (head, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static Boolean validate(TreeNode head,  long lowerbound, long upperbound){
        if (head == null){
            return true;
        }

        if (head.data<= lowerbound || head.data>= upperbound){
            return false;
        }

        return validate (head.left, lowerbound, head.data) && validate ( head.right, head.data, upperbound);
    }
}


/*
 * 7
5 1 4 -1 -1 3 6
false   to take a null input in the case of trees put a -1 

 */