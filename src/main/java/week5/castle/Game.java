package week5.castle;

import java.util.Scanner;

public class Game {
    private Room currentRoom;
        
    public Game() 
    {
        createRooms();
    }

    private void createRooms()
    {
        Room outside, lobby, pub, study, bedroom;
      
        //	制造房间
        outside = new Room("城堡外");
        lobby = new Room("大堂");
        pub = new Room("小酒吧");
        study = new Room("书房");
        bedroom = new Room("卧室");
        
        //	初始化房间的出口 north, east, south, west
        outside.setExit("east",lobby);
        outside.setExit("west",pub);
        outside.setExit("south",study);
        lobby.setExit("west",outside);
        /*扩展 up和down出口，就不需要修改room，故room有较好的可扩展性 */
        lobby.setExit("up",pub);
        pub.setExit("down",lobby);
        /*扩展*/
        pub.setExit("east", outside);
        study.setExit("north",outside);
        study.setExit("east",bedroom);
        bedroom.setExit("west",study);

        currentRoom = outside;  //	从城堡门外开始
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();
        showPrompt();
    }

    // 以下为用户命令

    private void printHelp() 
    {
        System.out.print("迷路了吗？你可以做的命令有：go bye help");
        System.out.println("如：\tgo east");
    }
    //根据一个direction 返回Room
    private void goRoom(String direction) 
    {
        Room nextRoom = currentRoom.getExit(direction);
//        Room nextRoom = null;
//        if(direction.equals("north")) {
//            nextRoom = currentRoom.northExit;
//        }
//        if(direction.equals("east")) {
//            nextRoom = currentRoom.eastExit;
//        }
//        if(direction.equals("south")) {
//            nextRoom = currentRoom.southExit;
//        }
//        if(direction.equals("west")) {
//            nextRoom = currentRoom.westExit;
//        }

        if (nextRoom == null) {
            System.out.println("那里没有门！");
        }
        else {
            currentRoom = nextRoom;
            showPrompt();
        }
    }
	public void showPrompt(){
        System.out.println("你在" + currentRoom);
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



	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Game game = new Game();
		game.printWelcome();
/*        命令解析的硬编码改造：
        函数不是对象*/
        while ( true ) {
        		String line = in.nextLine();
        		String[] words = line.split(" ");
        		if ( words[0].equals("help") ) {
        			game.printHelp();
        		} else if (words[0].equals("go") ) {
        			game.goRoom(words[1]);
        		} else if ( words[0].equals("bye") ) {
        			break;
        		}
        }
        
        System.out.println("感谢您的光临。再见！");
        in.close();
	}

}
