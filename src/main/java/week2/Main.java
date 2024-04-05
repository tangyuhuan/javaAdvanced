package week2;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
//        Test ts = new Test();
        Clock clock = new Clock(in.nextInt(),in.nextInt(),in.nextInt());
        clock.tick();
        System.out.println(clock);
        in.close();
    }
}
class Clock{
    private Display second = new Display(60);
    private Display minute = new Display(60);
    private Display hour = new Display(24);
    public Clock(int hour,int minute,int second){
        this.hour.setValue(hour);
        this.minute.setValue(minute);
        this.second.setValue(second);
    }
    public void tick(){
        second.increase();
        if(second.getValue()==0){
            minute.increase();
            if(minute.getValue()==0){
                hour.increase();
            }
        }
    }
    public String toString(){
        String str = String.format("%02d:%02d:%02d",hour.getValue(),minute.getValue(),second.getValue());
        return str;
    }
//    public void start(){
//        for(;;){
//            minute.increase();
//            if(minute.getValue()==0){
//                hour.increase();
//            }
//            System.out.printf("%02d:%02d\n",hour.getValue(),minute.getValue());
//        }
//    }
//    public static void main(String[] args) {
//        Clock clock= new Clock();
//        clock.start();
//    }

}

class Display{
    private int value;
    private int limit;
    private static int step = 1;
    public Display(int limit){
        this.limit = limit;
    }

    public void increase(){
        value++;
        if(value==limit){
            value=0;
        }
    }
    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }
//    public static void f(){
//        //无法从静态上下文中引用非静态 变量 value
//        //value++;
//    }
//    public static void main(String[] args) {
//        week2.display.Display d1 = new week2.display.Display(10);
//        week2.display.Display d2= new week2.display.Display(20);
//    }
}




