package week4.QA;

//以下哪些赋值是合法的？
//有四个类：Teacher和Student都是Person的子类，PhDStudent是Student的子类
public class PhDStudent extends Student {
    public static void main(String[] args){
        Person p1 = new Student();
        Person p2 = new PhDStudent();
        /*
        PhDStudent phd1 = new Student();//父类的对象不能赋值给子类的变量
        Teacher t1 = new Person();//父类的对象不能赋值给子类的变量
        */
        Student s1 = new PhDStudent();
        //s1 = p1; //父类的对象不能赋值给子类的变量
        //s1 = p2; //父类的对象不能赋值给子类的变量
        p1 = s1;
        //t1 = s1;
        //s1 = phd1;
        //phd1 = s1;
    }
}
