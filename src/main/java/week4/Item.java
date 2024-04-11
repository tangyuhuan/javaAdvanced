package week4;
//父类Item，CD和DVD类都继承自Item
public class Item {
    private String title;
    private int playingTime;
    private boolean gotIt = false;//标志：是否被借出去了
    private String comment;//描述性文字

    public Item(){

    }

    public Item(String title, int playingTime, boolean gotIt, String comment) {
        this.title = title;
        this.playingTime = playingTime;
        this.gotIt = gotIt;
        this.comment = comment;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void print() {
        System.out.print(title);
    }
}
