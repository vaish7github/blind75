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


        TreeNode head= arrtotree(nums);
        List<List<Integer>> result= levelOrder(head);
        for (List<Integer> list: result){
            for (int num:list){
                System.out.print(num+" ");
            }
            System.out.println();
        } 
                        
    }

    // function to convert an array to tree
    public static TreeNode arrtotree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        TreeNode head = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        
        int i = 1;

        if (i < nums.length) {
            TreeNode curr = queue.poll(); // this is a node pointer that is pointing at the head which will be moving and traversing the tree

            if (i< nums.length){
                curr.left= new TreeNode(nums[i++]);
                queue.offer(curr.left);
            }

            if (i<nums.length){
                curr.right =  new TreeNode (nums[i++]);
                queue.offer(curr.right);
            }
        }
        return head;
    }

    public static List<List<Integer>> levelOrder(TreeNode head){
        List<List<Integer>> result = new ArrayList<>();

        if (head== null){
            return result;
        }
        Queue <TreeNode> queue = new LinkedList<>();
        queue.offer(head);

        while (!queue.isEmpty()){
            int levelsize = queue.size();

            List<Integer > current = new ArrayList<>();
            for (int i=0; i<levelsize;i++){
                TreeNode curr= queue.poll();
                current.add(curr.data);
                if (curr.left!= null){
                    queue.offer(curr.left);
                }
                if (curr.right!= null){
                    queue.offer(curr.right);
                }
            }
            result.add(current);
        }
        return result;
    }
}