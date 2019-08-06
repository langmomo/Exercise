package Util;

import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;
import java.util.Queue;
public class StackExe {

    public static int basicCalculator(String s){
        //with parenthesis  (2*3)/2+3
        int len;
        if(s==null || (len = s.length())==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i=0;i<len;i++){

            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }else if(s.charAt(i)=='('){
                int left = 1;
                int right = 0;
                int start = i;
                while(left >right){
                    i++;
                    if(s.charAt(i)=='('){
                        left++;
                    }else if(s.charAt(i)==')'){
                        right++;
                    }
                }
                num=basicCalculator(s.substring(start+1, i));
                i++;

            }
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for(int i:stack){
            re += i;
        }
        return re;
    }
    Queue<Integer> q;
    public void impleByQueue(){
        q = new LinkedList<Integer>();
    }

    public void p(int item){
        q.offer(item);
    }

    public int po(){
        return 0;
    }


    public static void main(String[] args){
        System.out.println(basicCalculator("((1+2)*3-4)"));
    }
}
