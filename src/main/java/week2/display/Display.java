package week2.display;
//时钟=hh:mm
//有一个表达分钟的两位数计数器
//有一个表达小时的两位数计数器
//设计一个类表达这种两位数计数器
//构造出两个对象，一个表达分钟，一个表达小时,再组合起来，这两个对象间有交互
public class Display {
    private int value;
    private int limit;
    private static int step = 1;
    public Display(int limit){
        this.limit = limit;
    }

    public void increase(){
        value++;
        if(value==limit){
            value=0;
        }
    }
    public int getValue(){
        return value;
    }
    public static void f(){
        //无法从静态上下文中引用非静态 变量 value
        //value++;
    }
    public static void main(String[] args) {
//        Display d = new Display(24);
//        for(;;){
//            d.increase();
//            System.out.println(d.getValue());
//        }
        Display d1 = new Display(10);
        Display d2= new Display(20);
        d1.increase();
        //类函数中只能调用static函数、访问static变量
        //类变量和类函数可以直接访问，也可以通过对象访问
        f();
        d1.f();
        System.out.println(d1.step);
        System.out.println(d2.step);
        d1.step=2;
        System.out.println(d1.step);
        System.out.println(d2.step);
        Display.step=3;
        System.out.println(d1.step);
        System.out.println(d2.step);
    }
}
