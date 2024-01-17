package sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        // 对insert排序的一种优化
        // 每一轮将数组分成 size/2 组，每一组内进行 排序
        int[] arr = {8,9,1,7,2,3,5,4,6,0};

        System.out.println("Before shell sort: ");
        System.out.println(Arrays.toString(arr));
//		shellSort1(arr);
        shellSort2(arr);

        System.out.println("After shell sort: ");
        System.out.println(Arrays.toString(arr));
    }
    // 交换法
    public static void shellSort1(int[] arr) {
        int count = 0;
        int temp = 0;
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < arr.length; i++) {
                for(int j = i - gap; j >= 0; j -= gap) {
                    if(arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("Shell sort No " + (++count) + Arrays.toString(arr));
        }

    }
    // 移位法， 对比交换法，移位法更快一些
    public static void shellSort2(int[] arr) {
        // 每一次将组别拆分成/2这么多组
        int count = 0;
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j - gap]){
                    while(j-gap >= 0 && temp < arr[j-gap]) {
                        // move
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
            System.out.println("Shell sort No " + (++count) + Arrays.toString(arr));
        }
    }



}
