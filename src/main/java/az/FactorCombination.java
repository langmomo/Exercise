package az;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Numbers can be regarded as product of its factors. For example,
//
//        8 = 2 x 2 x 2;
//        = 2 x 4.
//        Write a function that takes an integer n and return all possible combinations of its factors.
//
//        Note: 
//
//        Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
//        You may assume that n is always positive.
//        Factors should be greater than 1 and less than n.
//        Examples: 
//        input: 1
//        output: 
//
//        []
//        input: 37
//        output: 
//        []
//        input: 12
//        output:
//        [
//        [2, 6],
//        [2, 2, 3],
//        [3, 4]
//        ]
//        input: 32
//        output:
//        [
//        [2, 16],
//        [2, 2, 8],
//        [2, 2, 2, 4],
//        [2, 2, 2, 2, 2],
//        [2, 4, 4],
//        [4, 8]
//        ]
public class FactorCombination {
    List<List<Integer>> finalResult = new ArrayList<>();
    List<String> visited = new ArrayList<>();
    public void solve(int target, List<Integer> result){
        //always find range [2,target/2]
        //stop condition factor 1 > factor rest
        if(target==1) {
            Collections.sort(result);
            if(!finalResult.contains(result)) finalResult.add(new ArrayList<>(result));
            return;
        }
        for(int i =2; i<= target/2; i++){
            if(target%i==0){
                result.add(i);
                result.add(target/i);
                Collections.sort(result);
                if(!finalResult.contains(result)) finalResult.add(new ArrayList<>(result));
                result.remove(result.indexOf(target/i));
                solve(target/i,result);
                result.remove(result.indexOf(i));
            }
        }
    }

    public void print(){
        for(List<Integer> item: finalResult){
            item.forEach(i->System.out.print(i+" "));
            System.out.println(" ");
        }
    }

    public static void main(String[] args){
        FactorCombination fc = new FactorCombination();
        fc.solve(32, new ArrayList<>());
        fc.print();
    }
}
