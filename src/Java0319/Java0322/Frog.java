package Java0319.Java0322;

public class Frog extends Animal implements IRunning,ISwimming {
    public Frog(String name) {
        super(name);
    }
    @Override
    public void swim(){
        System.out.println(this.name+"正在蹬腿游泳");
    }
    @Override
    public void run(){
        System.out.println(this.name+"正在往前跳");
    }
}
