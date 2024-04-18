package week7.castle;

import java.util.ArrayList;
/*第三种种任意门：
任意门只在这个城堡所有门之间轮转，会到达任意房间
“任意门只在这个城堡所有门之间轮转”，即需要拿到当前城堡所有门的数量，当前城堡有6扇门即有1/6的概率开启任意门
*/
public class RandomDoorThird extends RandomDoor {
    private int doorSum;

    public RandomDoorThird(ArrayList<Room> rooms, int doorSum) {
        super(rooms);
        this.doorSum = doorSum;
    }
    @Override
    public boolean isOpen() {
        double num= 1.0/doorSum;
        if(Math.random()<num){
            return true;
        }
        return false;
    }
}
