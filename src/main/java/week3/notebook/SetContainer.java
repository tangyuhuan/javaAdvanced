package week3.notebook;

import java.util.ArrayList;
import java.util.HashSet;

//集合容器set
//ArrayList顺序容器：可以不断向其中添加元素，按照添加的顺序进行存储。
//Set：即数学中的集合，元素不重复+无序
public class SetContainer {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("a");
        System.out.println(list);//[a, b, a]
        HashSet<String> set = new HashSet<String>();
        set.add("a");
        set.add("b");
        set.add("a");
        System.out.println(set);//[a, b]

        Value1 value = new Value1();
        value.setValue(5);
        //System.out.println会调用对象的toString函数输出内容
        System.out.println(value);

        HashSet<Integer> set2 = new HashSet<Integer>();
        set2.add(1);
        set2.add(999);
        set2.add(1);
        System.out.println(set2);//[a, b]

        //放进容器的是对象的管理者，若修改了放进去的对象，容器中的对象会变化
        HashSet<Value1> valueSet = new HashSet<Value1>();
        Value1 v1 = new Value1(123);
        valueSet.add(v1);
        valueSet.add(new Value1(456));
        System.out.println(valueSet);
        v1.setValue(789);
        System.out.println(valueSet);

    }
}

class Value1{
    private int value;
    public Value1(){
    }
    public Value1(int value){
        this.value = value;
    }
    public void setValue(int value){
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    //类可以重写了toString()方法饭回该对象的字符串表示
    public String toString(){
        return value+"";
    }
}