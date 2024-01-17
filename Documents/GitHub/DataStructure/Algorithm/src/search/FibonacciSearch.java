package search;

import java.util.Arrays;

public class FibonacciSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1234};
        System.out.println("index = " + fibonacciSearch(arr,10));
    }
    // 非递归方法得到一个fibonacci数列
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for(int i = 2; i < maxSize; i++){
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;

    }

    /**
     *
     * @param a 数组
     * @param key 需要查找的关键字
     * @return  返回对应的下标， 如果没有找到，返回-1
     */
    public static int fibonacciSearch(int[] a, int key){
        int low = 0;
        int high = a.length - 1;
        int k = 0; // 表示fib分割数值的下标
        int mid = 0; // 存放mid值
        int f[] = fib(); // 获取fib数列
        // 获取fibonacci分割数值的下标
        while(high > f[k] - 1){
            k++;
        }
        int[] temp = Arrays.copyOf(a,f[k]);
        for(int i = high + 1; i < temp.length; i++){
            temp[i] = a[high];
        }

        while(low <= high){
            mid = low + f[k - 1] - 1;
            if(key < temp[mid]){
                high = mid - 1;
                // 为什么k--：
                // 1。 全部元素= 前面的元素 + 后面的元素
                // 2。 f[k] = f[k - 1] + f[k - 2]
                // f[k - 1] 还可以继续拆分 下次循环mid = f[k-1-1]+1
                k--;
            }else if(key > temp[mid]){
                low = mid + 1;
                k -= 2;
            }else{
                if(mid <= high){
                    return mid;
                }else{
                    return high;
                }
            }
        }
        return -1;

    }
}
