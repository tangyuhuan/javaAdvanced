package week5.castle;

import java.util.ArrayList;
import java.util.HashSet;

/*基础任意门：会到达任意房间
1.到达任意房间的基础功能 2.任意门是否开启的判断
* */
public class RandomDoor {
    private ArrayList<Room> rooms;

    public RandomDoor(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
    //任意门是否开启的判断
    public boolean isOpen() {
        return false;
    }
    // 到达任意房间
    public Room getRoom() {
        int randomIndex = (int) (Math.random() * rooms.size());
        return rooms.get(randomIndex);
    }
}
