package week8;
//如果你的函数可能抛出异常，就必须在函数头部加以声明
class OpenException extends Throwable {
    public OpenException() {
    }
}
class CLoseException extends Throwable {
    public CLoseException() {
    }
}
public class ThrowExp {
    public static int open(){
//        int[] a = new int[2];
//        a[2] = 10;
        return -1;
    }
    public static void readFile() throws OpenException,CLoseException {
        if(open() == -1){
            throw new OpenException();
        }
    }
    public static void main(String[] args) {
        try {
            readFile();
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        } catch (OpenException e) {
            throw new RuntimeException(e);
        } catch (CLoseException e) {
            throw new RuntimeException(e);
        }
    }
}
