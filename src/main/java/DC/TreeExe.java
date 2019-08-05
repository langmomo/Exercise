package DC;


import java.util.*;
import java.util.stream.Collectors;

public class TreeExe extends Tree {

//    class TreeNode{
//        int val = 0;
//        TreeNode left = null;
//        TreeNode right = null;
//        TreeNode(int val){
//            this.val = val;
//        }
//    }

    public void inorderRecursion(TreeNode node, List<Integer> list){
        if(node ==null) return;
        inorderRecursion(node.left, list);
        list.add(node.val);
        inorderRecursion(node.right, list);

    }

    public void preorderRecursion(TreeNode node, List<Integer> list){
        if(node ==null) return;
        list.add(node.val);
        preorderRecursion(node.left, list);
        preorderRecursion(node.right, list);
    }

    public void postorderRecursion(TreeNode node, List<Integer> list){
        if(node ==null) return;
        postorderRecursion(node.left, list);
        postorderRecursion(node.right, list);
        list.add(node.val);
    }

    public void inorderIteration(TreeNode root, List<Integer> list){
        Stack<TreeNode> stack = new Stack<>();

    }

    public void preorderIteration(TreeNode root, List<Integer> list){
        Stack<TreeNode> stack = new Stack<>();

    }

    public void postorderIteration(TreeNode root, List<Integer> list){
        Stack<TreeNode> stack = new Stack<>();

    }

    public void levelorder(TreeNode root, List<Integer> list){
        Queue<TreeNode> q = new LinkedList<>();


    }

    public static void main(String[] args){
        //int[] nums = {4,2,6,1,3,5,7};
        String[] values = {"1","2","3",null, "4","5", null};

        TreeExe t = new TreeExe();
        //TreeNode node = t.generateTree(nums);
        TreeNode node = t.generate(values);
        List<Integer> list = new ArrayList<>();
        t.inorderRecursion(node, list);
        System.out.println(String.format("inorder %s %s", t.output(list), "recursion"));
        list.clear();
        t.inorderIteration(node, list);
        System.out.println(String.format("inorder %s %s", t.output(list), "iteration"));
        list.clear();
        t.preorderRecursion(node, list);
        System.out.println(String.format("preorder %s %s", t.output(list), "recursion"));
        list.clear();
        t.preorderIteration(node, list);
        System.out.println(String.format("preorder %s %s", t.output(list), "iteration"));
        list.clear();
        t.postorderRecursion(node, list);
        System.out.println(String.format("postorder %s %s", t.output(list), "recursion"));
        list.clear();
        t.postorderIteration(node, list);
        System.out.println(String.format("postorder %s %s", t.output(list), "iteration"));
        list.clear();
        t.levelorder(node, list);
        System.out.println(String.format("levelorder %s %s", t.output(list), "iteration"));
        list.clear();
        TreeNode root = t.generateFromPostPre();
        //t.levelorder(root, list);
        //System.out.println(String.format("postorder %s %s", t.output(list), "recursion"));



    }
}

