package az;

import java.util.Arrays;
import java.util.HashMap;

//Given an array of integers and an integer k, you need to find the total number of continuous subarrays
//        whose sum equals to k.  Example 1:  Input:nums = [1,1,1], k = 2 Output: 2
//        Note:  The length of the array is in range [1, 20,000].
//        The range of numbers in the array is [-1000, 1000] and the ra
public class SubarrayK {
    public void subarraySum(int[] nums, int k) {
        int val = traversal(nums, k);
        System.out.println(val);
    }

    public int traversal(int[] nums, int k){
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum-k==0){
                return i+1;
            }
            if(map.containsKey(sum-k)){
                return i-map.get(sum-k);
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1};
        SubarrayK l = new SubarrayK();
        l.subarraySum(nums, 2);
    }
}
