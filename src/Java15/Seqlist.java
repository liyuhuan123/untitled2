package Java15;

public class Seqlist<E> {
    //当前这个data的类型是啥，可以就当成一个Object[],Object具体代表的是哪种类型
    //需要最终在实例化Seqlist的时候才能够确定下来
    //E这样的泛型参数是不能被直接实例化的，当前可能还不知道E到低是啥类型
    private E[] data = (E[])new Object[100];
    private int size;
    public void add(E elem){
        data[size] = elem;
        size++;
    }
    public E get(int index){
        return data[index];
    }
    public static void main(String[] args){
        Seqlist<String> seqlist= new Seqlist<String>();
        seqlist.add("aaa");
        seqlist.add("bbb");
        String str = seqlist.get(0);
        System.out.println(str);
        Seqlist<Animal> animals = new Seqlist<>();
        animals.add(new Animal());
        animals.add(new Animal());
    }
}
