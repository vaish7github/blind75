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

        sc.close();
        TreeNode head = arrtotree(nums);
        int result =findDepth(head);
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

        while (i < nums.length) {
            TreeNode curr=queue.poll();

            // now for the left side of the tree
            if (i<nums.length){
                curr.left= new TreeNode(nums[i++]);
                queue.offer(curr.left);


            }
            if (i<nums.length){
                curr.right = new TreeNode (nums[i++]);
                queue.offer(curr.right);
            }

        }
        return head;

    }
    public static int findDepth(TreeNode head){
        if (head== null){
            return 0;
        }
        int left=  findDepth(head.left)+1;
        int right= findDepth(head.right)+1;

        return Math.max(left, right);
    }
}
