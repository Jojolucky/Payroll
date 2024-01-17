package sort;

import java.util.Arrays;

public class BucketSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 空间换时间的做法
        // 基数排序不支持负数，如果一定要负数的话，需要改进代码
        // 得出的排序结果，是位置稳定的，相对位置是不变的

        int[] arr = {53,3,542,748,14,214};
        System.out.println("排序前" + Arrays.toString(arr));
        radixSort(arr);
        System.out.println("排序后" + Arrays.toString(arr));

    }

    //  10 个桶,桶代表一个一维数组
    // 第一轮 个位数排序，分别放在对应的桶中
    // 第二轮 十位数排序，没有的位数，补充0
    // 以此类推
    public static void radixSort(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        // 因为每一次再桶中存储的数据不知道是多少，所以直接arr的长度
        int[] bucketCount = new int[10];
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        for(int i = 0,n = 1;  i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                // 取出对应位的数
                int digitElement = arr[j] / n % 10;
                bucket[digitElement][bucketCount[digitElement]] = arr[j];
                bucketCount[digitElement]++;
            }
            int index = 0;
            // 遍历每一个桶，将桶的元素放入到原数组
            for (int k = 0; k < bucketCount.length; k++) {
                if (bucketCount[k] != 0) {
                    //循环这个桶
                    for (int m = 0; m < bucketCount[k]; m++) {
                        arr[index] = bucket[k][m];
                        index++;
                    }
                }
                //每一轮处理完后，需要将其初始化为0
                bucketCount[k] = 0;
            }
            System.out.println(" 第" + (i + 1) + "轮：" + Arrays.toString(arr));
        }


//        for(int j = 0; j < arr.length; j++){
//            // 去除每个元素的个位
//            int digitElement = arr[j] % 10;
//            bucket[digitElement][bucketCount[digitElement]] = arr[j];
//            bucketCount[digitElement]++;
//        }
//        int index = 0;
//        // 遍历每一个桶，将桶的元素放入到原数组
//        for(int k = 0; k < bucketCount.length; k++){
//            if(bucketCount[k] != 0){
//                //循环这个桶
//                for(int n = 0; n < bucketCount[k]; n++){
//                    arr[index] = bucket[k][n];
//                    index++;
//                }
//            }
//        }
//        System.out.println(" 第一轮：" + Arrays.toString(arr) );

    }

}
