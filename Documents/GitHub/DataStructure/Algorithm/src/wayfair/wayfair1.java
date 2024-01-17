package wayfair;


import java.util.HashMap;
import java.util.Map;

public class wayfair1 {
    public static void main(String[] args) {
        int[] arr = {4,6,2,2,6,6,1};
        int res = maxLength(arr);
        System.out.println(res);
    }

    public static int maxLength(int[] A){
        int max = 0;
        int size = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < size; i++){
            if(map.containsKey(A[i])){
                max = Math.max(max, i - map.get(A[i]));
            }else{
                map.put(A[i], i);
            }
        }
        return max;
    }
}
