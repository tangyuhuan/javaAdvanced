package week7.castle;

import java.util.HashMap;

/*通过封装getExitDesc、getExit来降低耦合*/
public class Room {
    private String description;
/*    如果想要灵活性，就不能硬编码
    可以使用容器 表达每一个方向上的对应的房间*/
    HashMap<String,Room> exits = new HashMap<String,Room>();

    public Room(String description) {
        this.description = description;
    }
    public void setExit(String dir,Room room) {
        this.exits.put(dir, room);
    }

    @Override
    public String toString() {
        return description;
    }

//传入new String[0]参数是为了告诉JVM这个toArray的返回结果是一个String数组
//如果传入的数组长度小于集合中元素个数，就创建一个元素类型为a的运行时新数组，元素复制到新数组中
    public String[] getExitArray(){
        return exits.keySet().toArray(new String[0]);//集合转数组
    }
    public String getExitDesc() {
        //如果用String字符串做拼接的话，每次都会产生一个新的String对象，开销很大
        //而StringBuilder是一个不断修改的对象
        //改成hashmap后，描述变成从hashmap中拿出所有的key
        return exits.keySet().toString();
    }
    //根据一个direction 返回Room
    public Room getExit(String direction) {
        return exits.get(direction);
    }
}
