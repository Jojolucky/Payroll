package tiktokoa;

import java.sql.SQLOutput;
import java.util.Arrays;

public class OA1 {
    public static void main(String[] args) {
        String a = "4 2 3 4 1";
        String b = "1 2 3 4 5";
        boolean res = transformArray(a, b);
        System.out.println(res);

    }
    public static boolean transformArray(String a, String b){
        // change string a and b into int array
        String[] ch_a = a.split(" ");
        String[] ch_b = b.split(" ");
        int n = ch_a.length;
        int[] arr_a = new int[n];
        int[] arr_b = new int[n];
        for(int i = 0; i < n; i++){
            arr_a[i] = Integer.valueOf(ch_a[i]);
            arr_b[i] = Integer.valueOf(ch_b[i]);
        }
        Arrays.sort(arr_a);
        Arrays.sort(arr_b);
        for(int i = 0; i < arr_a.length; i++){
            if(arr_a[i] == arr_b[i] || arr_a[i] + 1 == arr_b[i]){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}
