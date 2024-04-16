package week5.castle;

import java.util.ArrayList;
/*第二种种任意门：
任意门只在这个房间所有门之间轮转，会到达任意房间
“任意门只在这个房间所有门之间轮转”，即需要拿到当前room所有门的数量，当前房间有3扇门即有1/3的概率开启任意门
*/
public class RandomDoorSecond extends RandomDoor {
    private Room room;

    public RandomDoorSecond(ArrayList<Room> rooms, Room room) {
        super(rooms);
        this.room = room;
    }

    @Override
    public boolean isOpen(Room room, String direction) {
        if(this.room.equals(room)) {
            double num= 1.0/room.getExitArray().length;
            if(Math.random()<num){
                return true;
            }
        }
        return false;
    }
}
