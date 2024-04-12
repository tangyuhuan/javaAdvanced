package week4;

import java.util.Objects;
//Override toString 和 equals方法
//定义一个CD类,它扩展了Item
public class CD extends Item{
//    private String title;
    private String artist;
    private int numofTracks;//有多少首歌
//    private int playingTime;
//    private boolean gotIt = false;//标志：是否被借出去了
//    private String comment;//描述性文字
//执行顺序：先做父类初始化（super(title);），再是子类定义的初始化（private boolean gotIt = false;），再是子类构造函数内（this.artist = artist;）
    public CD(String title, String artist, int playingTime, int numofTracks, boolean gotIt,String comment) {
//        this.title = title;
        super(title,playingTime,false,comment);
        this.artist = artist;
        this.numofTracks = numofTracks;
    }

    @Override
    public String toString() {
        return "CD{" +
                "artist='" + artist + '\'' +
                ", numofTracks=" + numofTracks +
                "} " + super.toString();
    }
//override覆盖，指在子类和父类中存在名称和参数表完全相同的函数，这一对函数构成覆盖关系。
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CD cd = (CD) o; //向下造型
        return numofTracks == cd.numofTracks && Objects.equals(artist, cd.artist);
    }
//    public boolean equals(CD cd) {
//        CD cd2 = (CD) cd;
//        return numofTracks == cd2.numofTracks && Objects.equals(artist, cd2.artist);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(artist, numofTracks);
//    }

    public static void main(String[] args) {
        CD cd = new CD("a","b",4,30,false,"...");
        CD cd2 = new CD("a","b",4,30,false,"...");
        //如果子类没有重写，用的就是Object的equals，判断则两个管理者管理的是不是同一个对象
        //重写了就调用子类的equals方法
        System.out.println(cd.equals(cd2));
        cd.print();//Item, CD执行的是Item的print函数
        /*
        当程序输出一个对象or把某个对象和字符串进行拼接运算时，
        系统会自动调用该对象的toString()方法返回该对象的字符串表示
        （默认的toString()方法返回的是类名@十六进制哈希码，一般情况下都需要重写）
        */
        System.out.println(cd.toString());//week4.CD@7a81197d  类名@内存地址
        System.out.println(cd);//week4.CD@7a81197d
    }
//    CD从Item得到继承，如果他没有自己的print函数，他也得到了Item的print函数
//    public void print() {
//        System.out.println(title+":"+artist);
//    }
}
