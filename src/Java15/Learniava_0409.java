package Java15;

import java.util.Arrays;

public class Learniava_0409 {
    //升序排序
    public static void insertSort(int[] array){
        for(int bound = 1;bound < array.length;bound++){
            int v = array[bound];
            int cur = bound - 1;
            for(;cur >= 0;cur--){
                if(array[cur] > v){
                    array[cur + 1] = array[cur];
                }else{
                    break;
                }
            }
            array[cur + 1] = v;
        }
    }
    public static void shellsort(int[] array){
        int gap = array.length/2;
        while(gap > 1){
            insertSortGap(array,gap);
            gap = gap / 2;
        }
        insertSortGap(array,1);
    }
    private static void insertSortGap(int[] array,int gap){
        for(int i = gap;i < array.length;i++){
            int v = array[i];
            int j = i - gap;
            for(;j >= 0;j-=gap){
                if(array[j] > v){
                    array[j + gap] = array[j];
                }else{
                    break;
                }
            }
            array[j+gap] = v;
        }
    }
    public static void selectSort(int[] array){
        for(int i = 0;i < array.length;i++){
            for(int j = i + 1;j < array.length;j++){
                if(array[j] <array[i]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    public static void bubbleSort(int[] array){
        for(int i = 0;i < array.length;i++){
            for(int j = array.length-1;j > i;j--){
                if(array[j] < array[i]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
    public static void main(String[] args){
        int[] array = {9,5,2,7,3,6,8};
        //insertSort(array);
        //shellsort(array);
        //selectSort(array);
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
