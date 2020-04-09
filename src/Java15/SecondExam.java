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
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
