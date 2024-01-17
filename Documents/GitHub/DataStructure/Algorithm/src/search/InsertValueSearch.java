package search;

import java.util.Arrays;

// 和binary search 一样，insert search 也要求数组是有序的
public class InsertValueSearch {
    // insert search 是binary search 的优化，可以解决如果需要查找的值在最左边或者最右边的一些case，
    // 减少search的次数
    // 如果数据跳跃性很大的话，insert search不一定更好
    public static void main(String[] args) {
        int[] arr = new int[100];
        for(int i = 0; i < 100; i++){
            arr[i] = i + 1;
        }
        int index = insertValueSearch(arr,1,arr.length-1,100);
        System.out.println("index = " + index);
//        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * @param arr
     * @param left
     * @param right
     * @param value  需要找的元素
     * @return  找到就返回下标值，没有找到就直接返回-1
     */
    public static int insertValueSearch(int[] arr, int left, int right, int value){
        // 注意： 该条件一定要有，除了可以优化之外，还可以确保mid值不越界
        if(left > right || value < arr[0] || value > arr[arr.length - 1]){
            return -1;
        }
        // insert search 的mid 和binary search的不同之处
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        if(value > midValue){
            return insertValueSearch(arr, mid + 1, right, value);
        }else if(value < midValue){
            return insertValueSearch(arr, left, mid - 1, value);
        }else{
            return mid;
        }

    }
}
