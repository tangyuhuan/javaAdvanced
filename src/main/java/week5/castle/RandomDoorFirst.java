package week5.castle;

import java.util.ArrayList;
/*第一种种任意门：
某个房间 某个出口出去，会到达任意房间*/
public class RandomDoorFirst extends RandomDoor{
    private Room targetRoom;
    private String targetDirection;
    private Room currentRoom;
    private String direction;

    public RandomDoorFirst(ArrayList<Room> rooms, Room targetRoom, Room currentRoom, String targetDirection, String direction) {
        super(rooms);
        this.targetRoom = targetRoom;
        this.currentRoom = currentRoom;
        this.targetDirection = targetDirection;
        this.direction = direction;
    }

    @Override
    public boolean isOpen() {
        if(this.targetRoom.equals(this.currentRoom) && this.targetDirection.equals(this.direction)) {
            return true;
        }
        return false;
    }
}
