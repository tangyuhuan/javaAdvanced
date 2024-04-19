package week8;
//抛出子类异常，会被捕捉父类异常的catch给捕捉到
//CLoseException1是OpenException1的子类
class OpenException1 extends Throwable {
    public OpenException1() {
    }
}
class CLoseException1 extends OpenException1 {
    public CLoseException1() {
    }
}
public class ThrowExp2 {
    public static int open(){
//        int[] a = new int[2];
//        a[2] = 10;
        return -1;
    }
    public static void readFile() throws CLoseException1 {
        if(open() == -1){
            throw new CLoseException1();
        }
    }
    public static void main(String[] args) {
        try {
            readFile();
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        } catch (CLoseException1 e) {
            //如果有多个catch块，会按照书写顺序依次匹配，子类需要写在父类的前面
            e.printStackTrace();
            System.out.println("close");
//            throw new RuntimeException(e);
        } catch (OpenException1 e) {
            //抛出子类异常，会被捕捉父类异常的catch给捕捉到
            e.printStackTrace();
            System.out.println("open");
//            throw new RuntimeException(e);
        }
    }
}
