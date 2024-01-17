import java.util.Arrays;
import java.util.PriorityQueue;

public class nineBox {
    public static void main(String[] args) {
        String s = "abcdefjabdfskf";
        long res = func(s);
        System.out.println(res);
    }

    public static long func(String s) {
        int res = 0;
        int[] cs = new int[26];
        for(int i = 0; i < s.length(); i++){
            cs[s.charAt(i) - 'a']++;
        }
        Arrays.sort(cs);
        for(int i = 25; i >= 0; i--){
            if(i >= 17){
                res += 1 * cs[i];
            }else if(i < 9){
                res += 3 * cs[i];
            }else{
                res += 2 * cs[i];
            }
        }
        return res;
    }
}