package week3.notebook;
import java.util.ArrayList;
//记事本
//3.2对象数组的for-each循环
class Value{
    private int value;
    public void setValue(int value){
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
public class NoteBook3 {
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
        //集合转数组toArray
        notes.toArray(a); //把ArrayList notes中的内容填入数组a中
        return a;
    }
    public static void main(String[] args) {
        int[] ia = new int[10];
        //for-each循环：对于基本类型的数组来说，在循环的每一轮的k，是对元素的复制品，不改变数组元素本身
        for(int k:ia){
            k++;
        }
        for(int i=0;i<ia.length;i++){
            System.out.println(ia[i]);
        }
//        对于对象类型的数组（例如String[]），for-each循环可以修改数组中的元素，因为它们是对象引用，可以拿到数组元素所管理的那个对象，对这个对象进行操作。
        Value[] values = new Value[10];
        for (int k = 0; k < values.length; k++) {
            values[k] = new Value();
            values[k].setValue(k);
        }

        for(Value v:values){
            System.out.println(v.getValue());//输出0到9
            //for-each循环对于对象数组来说，每一轮可以拿到数组元素所管理的那个对象，对这个对象进行操作。
            v.setValue(0);
        }
        for(Value v:values){
            System.out.println(v.getValue());//输出10个0
        }



        String[] words = {"Hello", "World"};
        for (String word : words) {
            // 正确: 修改的是引用
            word = "Java";
            System.out.println(word);
        }


//      容器类也可以使用for-each循环遍历容器中的元素
        ArrayList<String> al = new ArrayList<String>();
        al.add("first");
        al.add("second");
        for(String s:al){
            System.out.println(s);
        }

        Value v1 = new Value();
        System.out.println(v1);
        Value v2 = new Value();
        v1=v2;
        System.out.println(v1);
    }

}
