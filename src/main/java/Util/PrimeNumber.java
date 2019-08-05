package Util;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

    public void getAllPrime(int n){
        boolean[] Notprime = new boolean[n];
        List<Integer> list = new ArrayList<>();
        for(int i=2; i<n; i++){
            if(!Notprime[i]){
                list.add(i);
            }
            for(int j=2; j*i<n; j++){
                Notprime[j*i] = true;
            }
        }
    }

    public static void main(String[] args)
    {

    }
}
