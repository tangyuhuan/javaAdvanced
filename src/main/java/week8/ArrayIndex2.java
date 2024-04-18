package week8;

import java.util.Scanner;

public class ArrayIndex2 {
    public static void f(){
        int[] arr = new int[10];
        arr[10] = 1;
        System.out.println("hello");
    }
    public static void g(){
        f();
    }
    public static void h(){
        int i=10;
        if(i<100){
            g();
        }
    }
    public static void k(){
        try{
            h();
        }
//        catch(NullPointerException e){
//            System.out.println("k()");
//        }
        catch(ArrayIndexOutOfBoundsException e){//捕获到了异常
            System.out.println("k()");
            throw e;//异常被再次抛出
        }
    }
    public static void main(String[] args) {
//        k();
        try{
            k();
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("caught");
            System.out.println(e.getMessage());//Index 10 out of bounds for length 10
            System.out.println(e);//java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
            //函数调用过程中，怎么到最初发生异常的地方，中间调用的轨迹是怎样的
            e.printStackTrace();//输出被延后，调用堆栈
        }
        System.out.println("main");
//        输出：caught   main
//        try{
//            f();
//        }catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("caught");
//        }
//        System.out.println("main");

    }
}
