package az;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//297. Serialize and Deserialize Binary Tree (Design)
//        Hard
//        https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
//        Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
//        Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
//        For example, you may serialize the following tree
//        1
//        / \
//        2   3
//        / \
//        4   5
//        as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
//        Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

public class binarytree {
    class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public TreeNode serilize(List<Integer> list){
        TreeNode node = new TreeNode(list.get(0));
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        int i=1;
        while(stack.size()!=0 && i<=list.size()){
            TreeNode curNode = stack.pop();
            if(i<list.size()) {
                Integer leftVal = list.get(i++);
                if(leftVal!=null) {curNode.left = new TreeNode(leftVal);
                    stack.push(curNode.left);
                }
            }

            if(i<list.size()) {
                Integer rightVal = list.get(i++);
                if(rightVal!=null) {curNode.right = new TreeNode(rightVal);
                    stack.push(curNode.right);
                }
            }

        }
        return node;

    }

    public static void main(String[] args){

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(null);
        list.add(null);
        list.add(4);
        list.add(5);
        binarytree tree = new binarytree();
        TreeNode node = tree.serilize(list);


    }
}
