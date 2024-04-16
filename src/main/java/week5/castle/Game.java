package week5.castle;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;


public class Game {
    private Room currentRoom;
    private int count;
    HashMap<String, Handler> handlers = new HashMap<String, Handler>();
    ArrayList<Room> rooms = new ArrayList<Room>();

    /*    把程序的硬编码尽可能写为框架和数据的结构：
        命令的解析脱离if-else，定义不同的Handler来处理不同的命令，用Hash表来保存命令和Handler之间的关系
        今后如果想增加新的handler的类型，只要修改两个地方
        1.增加一个handlerXXXX继承handler
        2.修改Game的构造函数，完全不需要修改play()*/
    public Game(int count) {
        this.count = count;
        handlers.put("go", new HandlerGo(this));
        handlers.put("bye", new HandlerBye(this));
        handlers.put("help", new HandlerHelp(this));
        createRooms();
    }


    private void createRooms() {
        Room outside, lobby, pub, study, bedroom, secreroom;

        //	制造房间
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");
        secreroom = new Room("秘密基地");
        rooms.add(outside);
        rooms.add(lobby);
        rooms.add(pub);
        rooms.add(study);
        rooms.add(bedroom);
        rooms.add(secreroom);

        //	初始化房间的出口 north, east, south, west
        outside.setExit("east", lobby);
        outside.setExit("west", pub);
        outside.setExit("south", study);
        lobby.setExit("west", outside);
        /*扩展 up和down出口，就不需要修改room，故room有较好的可扩展性 */
        lobby.setExit("up", pub);
        pub.setExit("down", lobby);
        /*扩展*/
        pub.setExit("east", outside);
        study.setExit("north", outside);
        study.setExit("east", bedroom);
        bedroom.setExit("west", study);
        bedroom.setExit("down", secreroom);
        secreroom.setExit("up", bedroom);

        currentRoom = outside;  //	从城堡门外开始
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。共有5次机会寻找密室");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();
        showPrompt();
    }

    // 以下为用户命令
//    private void printHelp()
//    {
//        System.out.print("迷路了吗？你可以做的命令有：go bye help");
//        System.out.println("如：\tgo east");
//    }

    /*三种任意门：
    1.某个房间 某个出口出去，会到达任意房间
    2.任意门只在这个房间所有门之间轮转
    3.任意门只在这个城堡所有门之间轮转*/
    public void goRoom(String direction) {

//        RandomDoor randomDoor = new RandomDoorFirst(rooms, rooms.get(1), currentRoom, "west", direction);//任意门是固定的房间和方向，lobby，west。测试方法：go east+go west
//        RandomDoor randomDoor = new RandomDoorSecond(rooms, rooms.get(1), currentRoom);//任意门只在lobby房间所有门之间轮转
        RandomDoor randomDoor = new RandomDoorThird(rooms, getDoorsSum());//任意门只在这个城堡所有门之间轮转
        if (randomDoor.isOpen()) {
            currentRoom = randomDoor.getRoom();
            System.out.println("任意门开启！！来到房间" + currentRoom);
        } else {
            Room nextRoom = currentRoom.getExit(direction);
            if (nextRoom == null) {
                System.out.println("那里没有门！");
                return;
            } else {
                currentRoom = nextRoom;
            }
        }
        showPrompt();
    }

    public int getDoorsSum() {
        int sum = 0;
        for (Room room : rooms) {
            sum += room.getExitArray().length;
        }
        return sum / 2;
    }

    public void showPrompt() {
        System.out.println("你在" + currentRoom);
        if (currentRoom.toString().equals("秘密基地")) {
            System.out.println("找到了！");
            return;
        }

        System.out.print("出口有: ");
        System.out.print(currentRoom.getExitDesc());
//        if(currentRoom.northExit != null)
//            System.out.print("north ");
//        if(currentRoom.eastExit != null)
//            System.out.print("east ");
//        if(currentRoom.southExit != null)
//            System.out.print("south ");
//        if(currentRoom.westExit != null)
//            System.out.print("west ");
        System.out.println();
    }

    public void play(Game game) {
        /*命令解析的硬编码改造：
        函数不是对象，不能直接用hashmap存储*/

        while (count > 0) {
            count--;
            Scanner in = new Scanner(System.in);
            String line = in.nextLine();
            String[] words = line.split(" ");
            Handler handler = handlers.get(words[0]);
//            bye和help是没有words[1]的
            String value = "";
            if (words.length > 1) {
                value = words[1];
            }
            if (handler != null) {
                if (handler.isBye()) {
                    break;
                }
                //新命令加入的时候，help能自动输出，避免硬编码
                if (handler.isHelp()) {
                    value = handlers.keySet().toString().substring(1, handlers.keySet().toString().length() - 1);
                }
                handler.doCmd(value);
            }

//            if ( words[0].equals("help") ) {
//                game.printHelp();
//            } else if (words[0].equals("go") ) {
//                game.goRoom(words[1]);
//            } else if ( words[0].equals("bye") ) {
//                break;
//            }
        }
        System.out.println("机会已经用完");
    }

    public static void main(String[] args) {
        Game game = new Game(5);
        game.printWelcome();
        game.play(game);
        System.out.println("感谢您的光临。再见！");
//        in.close();
    }

}
