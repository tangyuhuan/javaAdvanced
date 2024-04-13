package week5.castle;

public class HandlerGo extends Handler {
    public HandlerGo(Game game) {
        super(game);
    }

    public void doCmd(String cmd) {
        game.goRoom(cmd);
    }
}
