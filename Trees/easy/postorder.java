import java.util.*;

class main{
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            data= x;
            left= null;
            right = null;
        }

    }

    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums= new int[n];
        for (int i=0;i< nums.length;i++){
            nums[i]= sc.nextInt();
        }
        sc.close();
        TreeNode head = arrtotree(nums);
        ArrayList<Integer> result =postorderTraversal(head);
        for (int num: result){
            System.out.print(num+ " ");
        }
        System.out.println();
    }

    public  static TreeNode arrtotree(int [] nums){
        if (nums.length ==0){
            return null;
        }

        Queue <TreeNode> queue = new LinkedList<>();

        TreeNode head = new TreeNode (nums[0]);
        queue.offer(head);

        int i =1;
        while (!queue.isEmpty() && i< nums.length){
            TreeNode curr= queue.poll();

            if (i< nums.length){
                curr.left = new TreeNode(nums[i++]);
                queue.offer(curr.left);
            }
            if (i< nums.length ){
                curr.right = new TreeNode(nums[i++]);
                queue.offer(curr.right);
            }
        }
        return head;
    }
    public static ArrayList<Integer> postorderTraversal(TreeNode head){
        ArrayList<Integer> ans = new ArrayList<>();
        postorder(head, ans);
        return ans;
    }
    public static void postorder(TreeNode head, ArrayList<Integer> ans){
        if (head== null){
            return;
        }

        postorder(head.left, ans);
        postorder(head.right, ans);
        ans.add(head.data);
    }
}