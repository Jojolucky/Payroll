package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
        // 冒泡排序的时间复杂度： O(n^2)
        // 冒泡排序的基本思想：
        // 1： 比较相邻的两个元素，如果前一个元素比后一个元素大，则交换位置。 第一次排序，最大的元素会放在末尾
        // 2: 第二次排序，放在倒数第二位，依次类推
        int arr[] = {3,9,-1,10,2};
        Date date = new Date();
        SimpleDateFormat sDateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        String d = sDateFormat.format(date);
        System.out.println("排序前" + Arrays.toString(arr));
        System.out.println("排序时间为" + d);

        bubbleSort(arr);
        System.out.println("排序后" + Arrays.toString(arr));
    }

//
//		for(int i = 0; i < arr.length-2; i++) {
//			if(arr[i] > arr[i+1]) {
//				temp = arr[i];
//				arr[i] = arr[i+1];
//				arr[i+1] = temp;
//			}
//
//		}
//		System.out.println("第二次排序：" + Arrays.toString(arr));
//
//		for(int i = 0; i < arr.length-3; i++) {
//			if(arr[i] > arr[i+1]) {
//				temp = arr[i];
//				arr[i] = arr[i+1];
//				arr[i+1] = temp;
//			}
//
//		}
//		System.out.println("第三次排序：" + Arrays.toString(arr));
//
//		for(int i = 0; i < arr.length-4; i++) {
//			if(arr[i] > arr[i+1]) {
//				temp = arr[i];
//				arr[i] = arr[i+1];
//				arr[i+1] = temp;
//			}
//
//		}
//		System.out.println("第四次排序：" + Arrays.toString(arr));




    // 将冒泡排序封装成一个方法
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        // 第一次排序，把最大的数放在了最后
        for(int i = 0; i < arr.length-1; i++) {
            for(int j = 0; j < arr.length -1 - i; j++) {
                if(arr[j] > arr[j+1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            System.out.println("第" + (i+1) + "次排序：" + Arrays.toString(arr));

            // 使用flag来进行标识，看当前次是否有又进行过交换，如果当前次没有发生过交换，则代表已经排序完成了
            // 不用再进行接下来的排序了
            if(!flag) {
                break;
            }else {
                flag = false;
            }

        }
    }

}
