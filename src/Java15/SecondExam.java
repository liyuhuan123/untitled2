package Java15;

import java.util.Arrays;

public class SecondExam {
    public static void insertSort(int[] array){
        for(int i = 1;i < array.length;i++){
            int v = array[i];
            int j = i - 1;
            for(;j >= 0;j--){
                if(array[j] > v){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = v;
        }
    }
    public static void heapSort(int[] array){
        //先建堆
        creatHeap(array);
        for(int i = 0;i < array.length;i++){
            int heapSize = array.length - i;
            swap(array,heapSize - 1,0);
            heapSize--;
            shiftDown(array,heapSize,0);
        }
    }
    private static void creatHeap(int[] array){
        for(int i = (array.length - 1 - 1)/2;i >= 0;i--){
            shiftDown(array,array.length,i);
        }
    }
    private static void shiftDown(int[] array,int heapSize,int index){
        int parent = index;
        int child = parent * 2 + 1;
        while(child < heapSize){
            if(child + 1 < heapSize && array[child + 1] > array[child]){
                child += 1;
            }
            if(array[parent] < array[child]){
                swap(array,child,parent);
            }else{
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }
    private static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void selectSort(int[] array){
        for(int i = 0;i < array.length;i++){
            for(int j = i + 1;j < array.length;j++){
                if(array[j] < array[i]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
    public static void bubbleSort(int[] array){
        for(int i = 0;i < array.length;i++){
            for(int j = array.length-1;j > i;j--){
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args){
        int[] array = {9,5,2,3,7,6,8};
        //insertSort(array);
        //selectSort(array);
        //bubbleSort(array);
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
