package week8;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
//对象串行化（把对象写到流里面去）
//类需要实现Serializable接口
class Student implements Serializable{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class IOTest7 {
    public static void main(String[] args) {
        try {
            Student s1 = new Student("linlin",18);
            System.out.println(s1);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("obj.dat"));
            out.writeObject(s1);
            out.close();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("obj.dat"));
            Student s2 = (Student)in.readObject();//Object cast 为Student
            in.close();
            System.out.println(s1==s2);//false，会制造一个新的对象。写入和读取的对象虽然值相同，确是两个不同的对象
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
