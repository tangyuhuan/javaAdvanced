package week5.castle;

public class Handler {
    //曲折办法：在Handler的构造函数中记录下game
    protected Game game;
    public Handler(Game game) {
        this.game = game;
    }
    public void doCmd(String cmd) {
    }
    public boolean isBye(){
        return false;
    }

}
