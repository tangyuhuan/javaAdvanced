package week2.clock;
//import 包名.类名
import week2.display.Display;

//对象是由其他对象组成的，而类定义了这样的组合关系。
//Clock对象由两个Display对象组成，并定义了他们的组合关系
public class Clock {
    private Display minute = new Display(60);
    private Display hour = new Display(24);
    public void start(){
        for(;;){
            minute.increase();
            if(minute.getValue()==0){
                hour.increase();
            }
            System.out.printf("%02d:%02d\n",hour.getValue(),minute.getValue());
        }
    }
    public static void main(String[] args) {
        Clock clock= new Clock();
        clock.start();
    }
}
