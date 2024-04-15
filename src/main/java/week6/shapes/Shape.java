package week6.shapes;

import java.awt.*;

/*抽象函数——表达概念而无法实现具体代码的函数
抽象类——表达概念而无法构造出实体的类*/
public abstract class Shape {
    //抽象方法不能有函数体
    public abstract void draw(Graphics g);
    //子类继承抽象类后，必须实现所有的抽象方法，否则子类也会成为抽象类
//	public abstract void move(Graphics g);
    public static void main(String[] args) {
//        Shape shape = new Shape();//抽象类不能实例化
    }
}
