package sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        // 将待排序的元素，看成有序表和无序表
        // 前半段为已经排序的有序表，后半段为待排序的无序表
        // 无序表的第一个元素，与有序表从后往前比较，放在刚好比它大的元素前面
        // 一共进行n-1 次排序
        int[] arr = {101,34,119,1,-1,5};
        System.out.println("Before insert sort: ");
        System.out.println(Arrays.toString(arr));
        insertSort(arr);

        System.out.println("After insert sort: ");
        System.out.println(Arrays.toString(arr));

    }

    public static void insertSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int index = i - 1; //  待插入的元素的前一个元素
            while(index >= 0 && val < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            // 推出while循环后，就是需要插入的位置
            arr[index+1] = val;
        }


    }
}
