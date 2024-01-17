import java.util.HashSet;

public class Stock {
    public static void main(String[] args) {
        int[] stock = new int[]{1,2,7,7,4,3,6};
        int res = func(stock, 3);
        System.out.println(res);
    }
    //Method: prefix sum + sliding window
    public static int func(int[] nums, int k) {
        if(k==0 || nums.length == 0) return 0;
        int sum = 0;
        int left = 0;
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for(int right = 0; right < nums.length; right++){
//            int len = right - left + 1;
            // 第一个while是确保窗口满足长度的要求，不能超过k
//            while(right - left + 1 > k){
//                sum -= nums[left];
//                set.remove(nums[left]);
//                left++;
//            }
            // 第二个while是确保窗口中没有重复的元素
            // 经过现在的修改，两个判断条件写在了一起，节省代码量
            while(right - left + 1 > k || (!set.isEmpty() && left < right && set.contains(nums[right]))){
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            set.add(nums[right]);
            sum += nums[right];

            if(right- left + 1 == k){
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
