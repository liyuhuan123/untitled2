package Java15;

import java.util.Arrays;

public class LearnJava_0407 {
    //通过size指定array中哪些元素是有效的堆元素
    //index表示从哪个位置的下标开始调整
    //左右子树都是堆，才能进行这样的调整
    public static void shiftDown(int[] array,int size,int index){
        int parent = index;
        int child = 2 * parent + 1;//根据parent下标找到左子树的下标
        while(child < size){
            //比较左右子树，找到较小值
            if(child + 1 < size && array[child + 1] <array[child]){
                child = child + 1;
            }
            //经过上面的比较，已经不知道child是左子树还是右子树了
            //知道的是child下标一定对应左右子树最小值的下标
            //拿child位置的元素和parent位置的元素进行比较
            if(array[child] < array[parent]){
                //不符合小堆的规则，就交换父子结点
                int temp = array[child];
                array[child] = array[parent];
                array[parent] = temp;
            }else{
                //调整完毕，不需要继续了
                break;
            }
            //更新一下parent和child,处理下一层的数据
            parent = child;
            child = parent * 2 + 1;
        }
    }
    public static void creatHeap(int[] array,int size){
        for(int i = (size -1 -1)/2;i >= 0;i--){
            shiftDown(array,size,i);
        }
    }
    public static void main(String[] args){
        int[] array = {9,5,2,7,3,6,8};
        creatHeap(array,array.length);
        System.out.println(Arrays.toString(array));
    }
}
