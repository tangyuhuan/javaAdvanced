package week8;
//如果想要捕获所有异常，可以使用catch(Exception)
class OpenException2 extends Throwable {
    public OpenException2() {
    }
}
class CLoseException2 extends OpenException1 {
    public CLoseException2() {
    }
}
public class ThrowExp3 {
    public static int open(){
        int[] a = new int[2];
        a[2] = 10;
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
        } catch (CLoseException1 e) {
            throw new RuntimeException(e);
        }
        catch (Exception e) {
            //如果想要捕获所有异常，可以使用catch(Exception)
//            e.printStackTrace();
            System.out.println("anything");
        }
    }
}
