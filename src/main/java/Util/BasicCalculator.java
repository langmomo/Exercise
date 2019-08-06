package Util;

import java.util.Stack;

public class BasicCalculator {

    public static int calculator(String s){
        Stack<Integer> stack = new Stack<>();

        int num=0;
        char sign='+';
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            if((!Character.isDigit(s.charAt(i)) && s.charAt(i)!=' ') || i == s.length()-1){
                if(sign=='+'){
                    stack.push(num);
                }else if(sign=='-'){
                    stack.push(-num);
                }else if(sign=='*'){
                    stack.push(stack.pop()*num);
                }else if(sign=='/'){
                    stack.push(stack.pop()/num);
                }

                num=0;
                sign = s.charAt(i);
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;

    }

    public static void main(String[] args){
        String str = "-2*5+2+4/4";
        System.out.println(calculator(str));
    }
}
