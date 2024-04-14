package week5.castle;

import java.util.ArrayList;
import java.util.HashSet;

/*三种任意门：
1.某个房间 某个出口出去，会到达任意房间
2.任意门只在这个房间所有门之间轮转
3.任意门只在这个城堡所有门之间轮转*/
public class RandomDoor {
//    private Room room;
//    private String direction;
    private ArrayList<Room> rooms;
    private String[] ExitArray;

    public RandomDoor(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
/*    public RandomDoor(String[] ExitArray){
        this.ExitArray = ExitArray;
    }
    public RandomDoor(Room room, String direction) {
        this.room = room;
        this.direction = direction;
    }*/

    // 到达任意房间
    public Room getRoom() {
        int randomIndex = (int) (Math.random() * rooms.size());
        return rooms.get(randomIndex);
    }
/*    public String getRoom2() {
        int random = (int)(Math.random()*ExitArray.length);
        return ExitArray[random];
    }*/


}
