package sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 采用分治的思想
        // 一直分解到最小单元，然后再merge的过程中，排序
        int[] arr = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        System.out.println("Before merge sort: ");
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1, temp);

        System.out.println("After merge sort: ");
        System.out.println(Arrays.toString(arr));

    }

    // 分+ 合
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if(left < right) {
            int mid = (left + right) / 2;
            //  向左递归分解
            mergeSort(arr, left, mid, temp);
            // 向右边递归分解
            mergeSort(arr, mid+1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     *
     * @param arr 需要排序的原始数组
     * @param left 左遍有序序列的初始索引
     * @param mid  中间索引
     * @param right 右边索引
     * @param temp 作为中转的临时数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; // 初始化i， 左边有序序列的初始索引
        int j = mid + 1; //初始化j， 右边有序序列的初始索引
        int t = 0; // 指向temp数组的当前索引

        // 1. 先把左右两边（有序） 的数据按照规则填充到temp数组中
        // 直到左右两边的有序序列，有一边处理完毕位置
        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            }else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        // 2. 把剩余数据的一边数据一次全部填充到temp中
        while(i <= mid) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while(j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        // 3. 把temp中的元素拷贝到arr
        // 注意不是全部拷贝，而且拷贝已经排序好的部分
        t = 0;
        int templeft = left;
        while(templeft <= right) { // 第一次合并，templeft = 0, right = 1
            arr[templeft] = temp[t];
            t += 1;
            templeft += 1;
        }
    }

}
