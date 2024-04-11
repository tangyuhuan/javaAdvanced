package week3.notebook;
import java.util.ArrayList;
//记事本
//3.1顺序容器之ArrayList
public class NoteBook {
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
    public ArrayList<String> getNotes(){
        return notes;
    }
    public static void main(String[] args) {
        NoteBook nb = new NoteBook();
        String str1 = "first";
        nb.add(str1);
        nb.add("second");
        nb.add("third",1);
        System.out.println(nb.getNotes());//ArrayList的toString方法，输出[first, third, second]
        System.out.println(nb.getSize());
        System.out.println(nb.getNote(0));
        System.out.println(nb.getNote(1));//third
        String[] a = nb.list();
        for(String arr:a){
            System.out.println(arr);
        }
    }

}
