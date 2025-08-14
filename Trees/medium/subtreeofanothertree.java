// 572. SubNode of Another Tree

import java.util.*;

class main {
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

        // now taking input for the sub tree
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        TreeNode head = arrtotree(nums);
        TreeNode SubNode = arrtotree(arr);
        System.out.print(isSubtree(head, SubNode));

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

    public static Boolean isSubtree(TreeNode head, TreeNode subHead){
        if (head == null){
            return false;
        }
        if (subHead== null){
            return true;
        }

        if (head.data == subHead.data){
            if (findSubtree(head,subHead)){
                return true;
            }
        }
        return isSubtree(head.left, subHead) || isSubtree(head.right, subHead);
    }

    public static Boolean findSubtree(TreeNode head, TreeNode subHead){
        if (head == null && subHead == null){
            return true;
        }

        if (head == null || subHead== null|| head.data!= subHead.data){
            return false;
        }
        if (!findSubtree(head.left, subHead.left)){
            return false;
        }
        if (!findSubtree(head.right, subHead.right)){
            return false;
        }

        return true;
    }

}