package search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        //  二分查找要求数组一定是有序的
        // 二分查找有递归和非递归的两种方式，此处使用递归的方式
        int[] arr = {1, 8, 10,10,10, 12, 14, 204};
        List<Integer> res = binarySearch(arr,0,arr.length - 1, 10);
        System.out.println(" res = " + res);

    }

    /**
     * @param arr
     * @param left
     * @param right
     * @param value 需要查找的值
     * @return 找到了就返回index，没有就返回-1
     */
    public static List<Integer> binarySearch(int[] arr, int left, int right, int value) {
        if(left > right){
            return new ArrayList<>();
        }
        int mid = left + (right - left) / 2;
        int midValue = arr[mid];
        if(value > midValue){
            return binarySearch(arr,mid + 1, right,value);
        }else if(value < midValue){
            return binarySearch(arr,left,mid - 1,value);
        }else{
//            return mid;   只返回一个的情况


            // 如果需要返回所有满足条件的索引
            List<Integer> resList = new ArrayList<>();
            int temp = mid - 1;
            while(true){
                if(temp < 0 || arr[temp] != value){
                    break;
                }
                resList.add(temp);
                temp -= 1;
            }
            resList.add(mid);
            temp = mid + 1;
            while(true){
                if(temp > arr.length - 1 || arr[temp] != value){
                    break;
                }
                resList.add(temp);
                temp += 1;

            }
            return resList;
        }

    }
}
