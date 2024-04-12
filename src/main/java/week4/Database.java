package week4;

import java.util.ArrayList;
import java.util.Objects;

//继承与多态
//CD资料库（存放CD的容器）
//定义父类Item后，Database不再直接管理CD和DVD类，而是管理item类
public class Database {
//    private ArrayList<CD> listCD = new ArrayList<CD>();
//    private ArrayList<DVD> listDVD = new ArrayList<DVD>();
    private ArrayList<Item> listItem = new ArrayList<Item>();

//    public void add(CD cd) {
//        listCD.add(cd);
//    }
//    //重载：函数名相同，参数不同
//    public void add(DVD dvd) {
//        listDVD.add(dvd);
//    }
    public void add(Item item) {
        listItem.add(item);
    }
    //list(利用CD的print函数遍历输出)
    public void list(){
//        for(CD cd:listCD){
//            cd.print();
//        }
//        for(DVD dvd:listDVD){
//            dvd.print();
//        }
        for(Item item:listItem){
            //多态：
            //所有的对象都是多态类型，通过变量调用函数时，会让实际管理的对象的类型去做print动作
            item.print();
        }
    }
    public static void main(String[] args) {
        int i = (int)10.2; //类型转换
        System.out.println(i); //10
        Item item = new Item("ttt",5,false,"???");
        Item item2 = new Item("ttt",5,false,"???");
        CD cd = new CD("cccc","cccc",4,30,false,"...");
        //cd = item; //父类的对象不能赋值给子类的变量
        //向上造型：子类的对象赋给父类的变量是ok的，等价于item = (Item)cd;
        //将cd当做Item类型来看待，但item实际存的还是CD类型变量
        item = cd;
        CD cc = (CD)item; //其实item管理的已经是CD类型的对象了，但是编译器不知道，所以要通过(CD)造型的方式告诉编译器，将item当做CD类型来看待
        //CD dd = (CD)item2; //会报错，Item cannot be cast to class CD，Item不能被造型为CD，不总是安全的
        Database db = new Database();
        db.add(new CD("aaa","aaaa",4,30,false,"..."));
        db.add(new CD("bbb","bbbb",4,30,false,"..."));
        db.add(new DVD("xxx","cccc",4,"..."));
        db.list();
    }
}
