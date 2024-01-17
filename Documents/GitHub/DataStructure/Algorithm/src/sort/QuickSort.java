package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        // 对bubble sort的一种优化
        // 1.找到中间索引的值作为基准值a，左边找比a大的，右边找比a小的，最后得到a左边的数都比a小，右边的都大
        // 2. 向左递归后，向右递归（左右可以根据情况自定义），一直重复1的排序操作
        // 得到结果
        int[] arr = {-9,78,0,23,-567,70,10,-1,900};
        System.out.println("Before quick sort: ");
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);

        System.out.println("After quick sort: ");
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right)/2]; // 找到中间值
        int temp = 0;
        while(l < r) {
            //左边找到比pivot大的
            while(arr[l] < pivot) {
                l += 1;
            }
            //右边找到比pivot小的
            while(arr[r] > pivot) {
                r -= 1;
            }

            if(l >= r) {
                break; // 说明arr已经满足了左边小，右边大的情况了
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // 需要收缩
            // 如交换后，arr[l] == pivot， r--，前移
            if(arr[l] == pivot) {
                r -= 1;
            }
            // 如交换后，arr[r] == pivot， l++，前移
            if(arr[r] == pivot) {
                l += 1;
            }
        }

        if(l== r) {
            l += 1;
            r -= 1;
        }
        // 向左向右递归
        if(left < r) {
            quickSort(arr, left, r);
        }
        if(right > l) {
            quickSort(arr, l, right);
        }
    }

}
