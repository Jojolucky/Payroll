package amazonoa;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class oa1 {
    public static void main(String[] args) {

    }
    public static int max(List<Integer> ans, List<Integer> need, int q){
        int size = ans.size();
        int[] diff = new int[size];
        for(int i = 0; i < size; i++){
            diff[i] = Math.max(ans.get(i) - need.get(i), 0);
        }
        Arrays.sort(diff);
        int res = 0;
        for(int i = 0; i < diff.length; i++){
            if(q - diff[i]> 0){
                res++;
                q -= diff[i];
            }else{
                break;
            }
        }
        return res;
    }
}
