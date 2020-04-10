package Java15;

public class Lt {
    //通过size来指定array中哪些元素是有效的堆元素
    //index表示从哪个位置的下标开始调整
    //左右子树都是堆，才能进行向下调整
    public static void shiftDown(int[] array,int size,int index){
        int parent = index;
        int child = 2 * parent + 1;
        while(child < size){
            //比较左右子树，找到较小值
            if(child + 1 < size && array[child+1] > array[child]){
                child = child + 1;
            }
            //经过上面的比较，已经不知道child是左子树还是右子树了，知道的是child下标一定对应左右子树最小值的下标
            if(array[child] < array[parent]){
                //不符合小堆的规则
                int temp = array[child];
                array[child] = array[parent];
                array[parent] = temp;
            }else{
                //调整完毕，不需要继续了
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }
    public static void creatHeap(int[] array){
        for(int i = (array.length - 1 - 1)/ 2;i>= 0;i--){
            shiftDown(array,array.length,i);
        }
    }
}

