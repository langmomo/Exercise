package Util;

import DC.Tree;

import java.util.ArrayList;
import java.util.List;


public class DFS extends Tree {
    static List<Integer> list = new ArrayList<>();
    public static void kDistanceDown(TreeNode node, int k){
        // Base Case
        if (node == null || k < 0)
            return;

        // If we reach a k distant node, print it
        if (k == 0)
        {
            list.add(node.val);
            return;
        }

        // Recur for left and right subtrees
        kDistanceDown(node.left, k - 1);
        kDistanceDown(node.right, k - 1);
    }


    public static int kDistance(TreeNode node, int k, int target){
        if(node ==null) return 0;
        if(node.val == target){
            kDistanceDown(node, k);
            return -1;  //parent node = -1
        }
        int left = kDistance(node.left, k, target);
        if(left<0){
            if(k+left==0){
                list.add(node.val);
            }else if(k+left>0){
                kDistanceDown(node.right, k+left-1);
            }

        }
        int right = kDistance(node.right, k, target);
        if(right<0){
            if(k+right==0){
                list.add(node.val);
            }else if(k+right>0){
                kDistanceDown(node.left, k+right-1);
            }

        }

        return left==0 && right ==0? 0: Math.min(left, right)-1;

    }

    public static void main(String[] args){
        String[] values = {"1","2","3",null, "4","5", null};
        Tree t = new Tree();
        //TreeNode node = t.generateTree(nums);
        TreeNode node = t.generate(values);
        kDistance(node,2,3);
        System.out.println(String.format("inorder %s %s", t.output(list), "iteration"));
    }

}
