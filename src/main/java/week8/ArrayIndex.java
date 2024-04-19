package week8;

import java.util.Scanner;
//处理异常
public class ArrayIndex {

    public static void main(String[] args) {
        int[] a = new int[10];
        Scanner scanner = new Scanner(System.in);
        int idx = scanner.nextInt();
        try{
            a[idx] = 1;//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
            System.out.println("Hello World");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
    }
}
