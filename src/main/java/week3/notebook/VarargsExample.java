package week3.notebook;
//可变参数（varargs）方法
//不定参数语法(Type... parametersName)

public class VarargsExample {
    public static void main(String[] args) {
        sum(1, 2);
        System.out.println();
        sum(1, 2,3);
    }
    //sum 方法接受任意数目的 int 类型参数，并通过 ... 语法将它们表示为一个数组
    public static void sum(int... numbers){
        for(int number : numbers){
            System.out.print(number+" ");
        }
    }
}
