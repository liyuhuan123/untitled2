package Java15;

import java.util.Arrays;

public class Learnjava_0410{
    public static void insertSort(int[] array){
        for(int bound = 1;bound < array.length;bound++){
            //[0,bound)是已排序区间
            int v = array[bound];
            int cur = bound - 1;
            for(;cur >= 0;cur--){
                if(array[cur] > v){
                    array[cur+1] = array[cur];
                }else{
                    break;
                }
            }
            array[cur+1] = v;
        }
    }
    public static void shellSort(int[] array){
        int gap = array.length / 2;
        while(gap > 1){
            insertSortGap(array,gap);
            gap = gap / 2;
        }
        insertSortGap(array,1);
    }
    public static void insertSortGap(int[] array,int gap){
        for(int bound = gap;bound < array.length;bound++){
            int v = array[bound];
            int cur = bound - gap;
            for(;cur >= 0;cur-=gap){
                if(array[cur] > v){
                    array[cur+gap] = array[cur];
                }else{
                    break;
                }
            }
            array[cur+gap] = v;
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
                if(array[j] > array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
    public static void heapSort(int[] array){
        //先建立堆
        creatHeap(array);
        //循环把堆顶元素交换到最后，并进行调整堆
        //循环此时是length-1，当堆中只剩一个元素时，也就一定是有序的了
        for(int i = 0;i < array.length;i++){
            //当前堆的元素个数
            int heapSize = array.length-i;
            swap(array,0,heapSize-1);
            heapSize--;
            shiftDown(array,heapSize,0);
        }
    }
    private static void creatHeap(int[] array){
        //从最后一个非叶子结点出发向前循环，依次向下进行调整
        for(int i = (array.length -1 -1)/2; i >= 0;i--){
            shiftDown(array,array.length,i);
        }
    }
    private static void shiftDown(int[] array,int heapLength,int index){
        int parent = index;
        int child = 2 * parent + 1;
        while(child < heapLength){
            if(child + 1 < heapLength && array[child + 1] > array[child]){
                child += 1;
            }
            if(array[child] > array[parent]){
                swap(array,child,parent);
            }else{
                break;
            }
            parent = child;
            child = 2*parent +1;
        }
    }
    private static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args){
        int[] array = {9,5,2,3,7,6,8};
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        //bubbleSort(array);
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

}
