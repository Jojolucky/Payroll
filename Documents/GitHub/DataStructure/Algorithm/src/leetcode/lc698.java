package leetcode;

import java.util.Arrays;

public class lc698 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;
        boolean res = canPartitionKSubsets(nums, k);
        System.out.println(res);

    }
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum % k != 0 || nums.length < k) return false;
        Arrays.sort(nums);
        int target = sum / k;
        return helper(nums, target, nums.length - 1, new int[k]);

    }
    public static boolean helper(int[] a,int target,int index,int bucket[]){
        if(index < 0) return true;
        for(int j = 0; j < bucket.length; j++){
            if(bucket[j] + a[index] <= target){
                bucket[j] += a[index];
                if(helper(a,target,index-1,bucket)) return true;
                bucket[j] -= a[index];

            }
            if(bucket[j] == 0) break;
        }
        return false;
    }
}
