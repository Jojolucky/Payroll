package expedia;

import java.util.HashMap;
import java.util.Map;

/*
* There are n candidates and a total of n/2 teams to be formed. Each candidate has a skill level denoted by skill[i]. Make teams so that the total skill is the same and return the sum of efficiencies
If there is no way to create the teams that satisfy these conditions, return -1.
Efficiency is calculated like this:

Efficiency of team [1, 3] = 1* 3 = 3
Efficiency of team [2, 2] = 2 * 2 =  4
Example:
The skills of the candidates are skill = [1, 2, 3, 2] so they can be paired as [1, 3], [2, 2].

Efficiency:[ 1, 3] = 1* 3 = 3
Efficiency: [2, 2] = 2 * 2 = 4

Should return the sum of efficiencies: 3 + 4 = 7*/
public class efficientTeam {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2};
        int res = findEfficient(arr);
        System.out.println(res);

    }
    public static int findEfficient(int[] arr){
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        int res = 0;
        int pairSum = sum / arr.length * 2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(pairSum < arr[i]){
                return -1;
            }
            if(map.containsKey(arr[i])){
                res += arr[i] * (pairSum - arr[i]);
                map.put(arr[i], map.get(arr[i]) - 1);
                if(map.get(arr[i]) == 0){
                    map.remove(arr[i]);
                }
            }else{
                map.put(pairSum - arr[i], 1);
            }
        }
        return map.isEmpty() ? res : -1;
    }
}
