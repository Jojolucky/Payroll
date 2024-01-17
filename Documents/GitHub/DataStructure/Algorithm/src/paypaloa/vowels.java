package paypaloa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class vowels {
    public static void main(String[] args) {
        String[] str = {"aba", "bcb", "ece","aa","e"};
        String[] q = {"1-3", "2-5", "2-2"};
        int[] res = findRes(str, q);
        for(int i : res){
            System.out.println(i);
        }
    }
    public static int[] findRes(String[] str, String[] q){
        Character[] vowel = {'a','e','i','o','u'};
        Set<Character> set = new HashSet<>(Arrays.asList(vowel));
        // presum used to record the count of valid string from beginning
        int[] presum = new int[str.length + 1];
        for(int i = 1; i <= str.length; i++){
            if(set.contains(str[i - 1].charAt(0)) && set.contains(str[i - 1].charAt(str[i - 1].length() - 1))){
                presum[i] = presum[i - 1] + 1;
            }else{
                presum[i] = presum[i - 1];
            }
        }
        int[] res = new int[q.length];
        for(int i = 0; i < q.length; i++){
            String[] ch = q[i].split("-");
            int start = Integer.parseInt(ch[0]);
            int end = Integer.parseInt(ch[1]);
            res[i] = start == 1 ? presum[end] : presum[end] - presum[start - 1];
        }
        return res;
    }
}
