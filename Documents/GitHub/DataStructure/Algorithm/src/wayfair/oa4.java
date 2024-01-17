package wayfair;

import java.util.HashMap;

public class oa4 {
    public static void main(String[] args) {
        String s = "acb";
        int res = findTheLongestSubstring(s);
        System.out.println(res);

    }
    public static int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> map= new HashMap<>();
        map.put(0, -1);
        int xor = 0;
        int max = 0;
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            xor ^= arr[i] - 'a' + 1;
            if (!map.containsKey(xor)) {
                map.put(xor, i);
            }
            max = Math.max(max, i - map.get(xor));
        }
        return max;
    }
}
