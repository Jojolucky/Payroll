package wayfair;

import java.util.HashMap;
import java.util.Map;

public class wayfair3 {
    public static void main(String[] args) {
        String s = "BANANADHNANABA";
        int res = remove(s);
        System.out.println(res);

    }
    public static int remove(String s){
        int size = s.length();
        Map<Character, Integer> target = new HashMap<>();
        target.put('B',0);
        target.put('A',0);
        target.put('N',0);
        char[] ch = s.toCharArray();
        for(int i = 0; i < size; i++){
            if(target.containsKey(ch[i])){
                target.put(ch[i], target.get(ch[i]) + 1);
            }
        }
        int res = Integer.MAX_VALUE;
        for(char c : target.keySet()){
            if(c == 'A'){
                res = Math.min(res, target.get(c) / 3);
            }else if(c == 'B'){
                res = Math.min(res, target.get(c));
            }else{
                res = Math.min(res, target.get(c) / 2);
            }
        }
        return res;

    }
}
