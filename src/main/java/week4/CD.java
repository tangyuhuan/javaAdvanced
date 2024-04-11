package week4;

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

    public static void main(String[] args) {
        CD cd = new CD("a","b",4,30,false,"...");
        cd.print();//Item, CD执行的是Item的print函数
    }
//    CD从Item得到继承，如果他没有自己的print函数，他也得到了Item的print函数
//    public void print() {
//        System.out.println(title+":"+artist);
//    }
}
