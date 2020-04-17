package LearnJava_0417;

public class Sort {
    public static void insertSort(int[] array){
        for(int i = 1;i < array.length;i++){
            int v = array[i];
            int j = i - 1;
            for(;j >= 0;j--){
                if(array[j] > v){
                    array[j + 1] = array[j];
                }
            }
            array[j + 1] = v;
        }
    }
    public static void shellsort(int[] array){
        int group = array.length / 2;
        while(group > 1){
            insertshellSort(array,group);
            group = group / 2;
        }
        insertshellSort(array,1);
    }
    public static void insertshellSort(int[] array,int group){
        for(int i = group;group < array.length;group++){
            int v = array[i];
            int j = i - group;
            for(;j >= 0;j--){
                if(array[j] > v){
                    array[j + group] = array[j];
                }
            }
            array[j + group] = v;
        }
    }
    public static void selectSort(int[] array){
        for(int i = 0;i < array.length;i++){
            for(int j = i + 1;j < array.length;j++){
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    public static void bubbleSort(int[] array){
        for(int i = 0;i < array.length;i++){
            for(int j = array.length - 1;j > i;j--){
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
//    public static void heapSort(int[] array){
//        //1.先建堆
//        creatHeap(array);
//        for(int i = 0; i < array.length;i++){
//            swap()
//        }
//    }
    public static void main(String[] args){

    }
}
