package Java0319;

public class Person {
    private String name;
    private int age;
    //构造方法
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void show(){
        System.out.println("name:"+name+" "+"age:"+age);
    }
    //重写object的toString方法
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
