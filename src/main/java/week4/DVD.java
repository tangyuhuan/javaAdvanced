package week4;

//定义一个DVD类
//子类构造器执行顺序
public class DVD extends Item{
//    private String title;
    private String director;
//    private int playingTime;
//    private boolean gotIt = false;//标志：是否被借出去了
//    private String comment;//描述性文字

    public DVD(String title, String director, int playingTime, String comment) {
//        super();
//        当构造子类对象时，首先要确保父类的成员变量得到恰当初始化（1.定义初始化 2.构造器）
//        一个类执行的顺序是先1.定义初始化，后2.构造器
//        当其有父类时，执行顺序是 1.父类的部分（1.定义初始化 2.构造器）先做  2.子类的（1.定义初始化 2.构造器）
//        如果没有super(),子类默认会调用父类无参构造器，即super()可以省略
//        如果有参数super(XXX)，子类会调用父类的有参构造器
//        this.title = title;//在子类函数中指的是子类自己的变量
        super(title,playingTime,false,comment);
        setTitle("b");//父类private对象，子类不可见，可以通过父类的函数去操作，在父类函数中指的是父类自己的变量
//        super(title);
        this.director = director;
//        this.playingTime = playingTime;
//        this.comment = comment;
    }

    public static void main(String[] args) {
        DVD dvd = new DVD("aaa","bbb",30,"...");
        dvd.print();
    }

    public void print() {
//        System.out.println(title+":"+director);
        //调用父类的print函数
        super.print();
        System.out.println(":"+director);
    }
}
