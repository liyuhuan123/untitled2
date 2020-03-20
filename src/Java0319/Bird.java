package Java0319;

public class Bird extends Animal{
    public Bird(String name) {
        super(name);
    }
    public void eat(String food){
        System.out.println("我是一只小鸟");
        System.out.println(this.name+"正在吃"+food);
    }

    public void fly(){
        System.out.println(this.name+"正在飞");
    }

}
