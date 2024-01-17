package wayfair;

import java.util.Arrays;
import java.util.Scanner;

public class oa5 {
    public static void main(String[] args){
       int[] A = {11,15,20,9};
        int ans = solution(A);
        System.out.println(ans);
    }

    public static int solution(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        int max = 0;
        double diff = A[A.length - 1] + A[0];
        double mid = diff / 2;
        int pre = 0, post = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] >= mid) {
                post = i;
                break;
            }
        }

        pre = post - 1;
        int res = Math.max(A[pre] - A[0], A[A.length - 1] - A[post]);
        return res;
    }
}
