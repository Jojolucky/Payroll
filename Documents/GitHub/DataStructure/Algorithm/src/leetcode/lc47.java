package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc47 {
    public static void main(String[] args) {
        int[] arr = {3,1,1,2};
        List<List<Integer>> res = permuteUnique(arr);
        System.out.println(res.toString());

    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        helper(res, nums, visited, new ArrayList<>());
        return res;
    }
    public static void helper(List<List<Integer>> res, int[] nums, boolean[] visited, List<Integer> cur){
        if(cur.size() == nums.length) res.add(new ArrayList<>(cur));
        for(int i = 0; i < nums.length; i++){
            if(visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            cur.add(nums[i]);
            visited[i] = true;
            helper(res, nums, visited, cur);
            cur.remove(cur.size() - 1);
            visited[i] = false;
        }
    }
}
