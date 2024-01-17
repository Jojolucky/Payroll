package leetcode;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc22 {
    public static void main(String[] args) {
        int n = 3;
        for(String s : generateParenthesis(n)){
            System.out.println(s.toString());
        }
    }

//    public static List<String> generateParenthesis(int n) {
//        List<String> res = new ArrayList<>();
//        backtrack(res,"",n ,n);
//        return res;
//    }
//
//    public static void backtrack(List<String> res,String curr,int left,int right){
//        if(left == 0 && right == 0){
//            res.add(curr);
//            return;
//        }
//        if(left > 0){
//            backtrack(res,curr + "(", left -1 , right);
//        }
//        if(right > left){
//            backtrack(res,curr + ")", left , right -1);
//        }
//    }
    static List<String> res = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        StringBuilder cur = new StringBuilder();
        dfs(cur, 0, 0, n);
        return res;
    }

    public static void dfs(StringBuilder cur, int left, int right, int n){
        if(cur.length() == 2 * n){
            res.add(cur.toString());
            return;
        }

        if(left < n){
            cur.append("(");
            dfs(cur, left + 1, right, n);
            cur.deleteCharAt(cur.length() - 1);
        }

        if(left > right){
            cur.append(")");
            dfs(cur, left, right + 1, n);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
