package week5.castle;

import java.util.ArrayList;
/*第一种种任意门：
某个房间 某个出口出去，会到达任意房间*/
public class RandomDoorFirst extends RandomDoor{
    private Room room;
    private String direction;

    public RandomDoorFirst(ArrayList<Room> rooms, Room room, String direction) {
        super(rooms);
        this.room = room;
        this.direction = direction;
    }

    @Override
    public boolean isOpen(Room room, String direction) {
        if(this.room.equals(room) && this.direction.equals(direction)) {
            return true;
        }
        return false;
    }
}
