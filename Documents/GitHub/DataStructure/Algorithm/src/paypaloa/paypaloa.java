package paypaloa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class paypaloa {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0,-1);
        arr.add(1,3);
        arr.add(2,4);
        arr.add(3,-10);
        int res = maxfind(arr);
        System.out.println(res);

    }
    public static int maxfind(List<Integer> arr){
        Collections.sort(arr);
        int psum = 0;
        int res = 0;
        int size = arr.size();
        for(int i = size - 1; i >= 0; i--){
            psum += arr.get(i);
            if(psum > 0){
                res++;
            }
        }
        return res;
    }
}
