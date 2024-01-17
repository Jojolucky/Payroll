package search;

public class SequenceSearch {
    public static void main(String[] args) {
        // 线性查找是找到一个目标值，则即可返回，
        int[] arr = {1,9,11,-1,34,89}; // 可以是有序的，也可以是无序的
        int index = sequenceSearch(arr,89);
        if(index == -1){
            System.out.println("Can not find the number");
        }else{
            System.out.println("Find the number, it's index is " + index);
        }

    }

    public static int sequenceSearch(int[] arr, int value){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}
