package week3.notebook;
import java.util.ArrayList;
//记事本
//3.2对象数组
//当数组的元素类型是类的时候，数组的每个元素存放的是引用的地址（是对象的管理者而不是对象本身）。
//仅仅创建数组并没有创建其中的每一个对象。
//与基础类型数组创建默认初始化不同，创建对象数组后，还需要把数组中的每一个对象创建出来。

public class NoteBook2 {
    private ArrayList<String> notes= new ArrayList<String>();
    public void add(String s)
    {
        notes.add(s);
    }
    public void add(String s, int location)
    {
        notes.add(location,s);
    }
    public int getSize()
    {
        return notes.size();
    }
    //ArrayList是顺序容器，可以通过索引取出
    public String getNote(int index){
        return notes.get(index);
    }
    public void removeNote(int index){
        notes.remove(index);
    }
    //列出所有的记录
    public String[] list(){
        String[] a = new String[notes.size()];
        notes.toArray(a); //把ArrayList notes中的内容填入数组a中
        return a;
    }
    public static void main(String[] args) {
        boolean[] b = new boolean[10];
        System.out.println(b[0]);//false
        int[] ia = new int[10];
        String[] a = new String[10];
        System.out.println(ia[0]);//0
        System.out.println(a[0]);//null
        System.out.println(a[0]+"a");//nulla
//        System.out.println(a[0].length()); //error
        //建对象数组后，还需要把数组中的每一个对象创建出来
        for (int i = 0; i < a.length; i++) {
            a[i] = ""+i;
        }
        System.out.println(a[0]);
        System.out.println(a[0].length());
    }

}
