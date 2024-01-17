package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        // 大顶堆： 父节点的值大于等于左节点和右节点
        // 小顶堆： 父节点的值小于等于左右节点
        // 先将数组构造成大顶堆（升序），小顶堆（降序）
        // 把最大的数移除后，继续构造顶堆，以此类推

        int[] arr = {4,6,8,5,9,-1,90,-76};
        heapSort(arr);
    }

    public static void heapSort(int arr[]){
        int temp = 0;
        System.out.println("Heap sort");
//        adjustHeap(arr,1,arr.length);
//        System.out.println("The 1st time: " + Arrays.toString(arr));
//        adjustHeap(arr,0,arr.length);
//        System.out.println("The 2nd time: " + Arrays.toString(arr));

        for(int i = arr.length / 2 - 1; i >= 0; i--){
            adjustHeap(arr,i,arr.length);
        }
        for(int j = arr.length - 1; j > 0; j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }

        System.out.println("The result: " + Arrays.toString(arr));

    }

    /**
     *
     * @param arr the array need to be sorted
     * @param i  the index of the leaf in the array
     * @param length  the number of elements which are waitting to be sort
     */
    // 调整成大（小）顶堆
    public static void adjustHeap(int arr[], int i, int length){
        int temp = arr[i];
        // k = i * 2 + 1, k is the left node of i
        for(int k = i * 2 + 1; k < length; k = k * 2 + 1){
            if(k + 1 < length && arr[k] < arr[k + 1]){ // the value of left node is less than right node
                k++;
            }
            if(arr[k] > temp){
                arr[i] = arr[k];
                i = k; // i lead to k, and then go on its loop
            }else{
                break;
            }
        }
        // when for loop is end,  those nodes which used i as parent, the biggest value is the root
        arr[i] = temp;
    }
}
