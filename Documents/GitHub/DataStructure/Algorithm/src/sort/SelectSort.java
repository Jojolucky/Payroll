package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        // 选择排序的时间复杂度： O(n^2) 但是比冒泡排序要快！！！
        // 思想： 每一次将当前最小值放在档次排序的前面
        // 第一次： arr[0] - arr[n-1], 找到最小值，放在arr[0]
        // 第二次： arr[1] - arr[n-1], 找到最小值，放在arr[1]
        // 一共进行size-1 次排序
        int[] arr = {101,34,119,1};
        System.out.println("Before select sort: ");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);

        System.out.println("After select sort: ");
        System.out.println(Arrays.toString(arr));

    }

    public static void selectSort(int[] arr) {
        // 第i轮
        for(int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for(int j= i + 1; j < arr.length; j++) {
                if(min > arr[j]) { // find the min element
                    min = arr[j];
                    minIndex = j;
                }

            }
            if(minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

        }



    }

}
