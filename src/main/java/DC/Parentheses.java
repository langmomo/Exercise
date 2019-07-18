package DC;
//Different Ways to Add Parentheses
//        Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are+, - and *.
//
//        Example 1
//
//        Input: "2-1-1".
//
//        ((2-1)-1) = 0
//        (2-(1-1)) = 2
//        Output: [0, 2]
//
//        Example 2
//
//        Input: "2*3-4*5"
//
//        (2*(3-(4*5))) = -34
//        ((2*3)-(4*5)) = -14
//        ((2*(3-4))*5) = -10
//        (2*((3-4)*5)) = -10
//        (((2*3)-4)*5) = 10
//        Output: [-34, -14, -10, -10, 10]


import java.util.ArrayList;
import java.util.List;

public class Parentheses {
    //partition 2 part and combination
    public List<Integer> solve(String s){
        List<Integer> result = new ArrayList<>();
        if(s.length() == 1){

            result.add(Integer.parseInt(s));
            return result;
        }
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='+'){
                List<Integer> result1 = solve(s.substring(0, i));
                List<Integer> result2 = solve(s.substring(i+1));
                for(Integer r1: result1){
                    for(Integer r2: result2){
                        result.add(r1+r2);
                    }
                }

            }else if(s.charAt(i)=='-'){
                List<Integer> result1 = solve(s.substring(0, i));
                List<Integer> result2 = solve(s.substring(i+1));
                for(Integer r1: result1){
                    for(Integer r2: result2){
                        result.add(r1-r2);
                    }
                }
            }else if(s.charAt(i)=='*'){
                List<Integer> result1 = solve(s.substring(0, i));
                List<Integer> result2 = solve(s.substring(i+1));
                for(Integer r1: result1){
                    for(Integer r2: result2){
                        result.add(r1*r2);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Parentheses p = new Parentheses();
        List<Integer> re = p.solve("2*3-4*5");
        re.forEach(item->System.out.print(item+ " "));
    }
}
