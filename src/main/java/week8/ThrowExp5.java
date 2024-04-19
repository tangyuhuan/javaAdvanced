package week8;
//子类的构造函数中，必须声明父类可能抛出的全部异常
class OpenException5 extends Exception { }
class CLoseException5 extends OpenException5 { }
class NewException5 extends Exception {}
public class ThrowExp5 {
    public ThrowExp5() throws OpenException5 {}
    public void f() throws OpenException5 {}
    public void f2() throws NewException5 {}
    public static void main(String[] args) {
    }
}

class NewClass1 extends ThrowExp5{
    //子类对象创建时，是会调用父类的构造器，而父类的构造被调用时是有可能抛出OpenException4的
    //子类的构造函数必须要声明（创建子类对象时无从知道父类的情况，必须要把异常声明出来）
//    public NewClass1() {
//    }
    //作为子类的构造函数可以增加比父类构造函数更多的异常
    //因为构造过程中会自动调用父类的构造，父类的构造会全部声明了，可以添加自己的
    public NewClass1() throws OpenException5,NewException5 {
    }

    public void f() throws OpenException5{}
    public static void main(String[] args) {
        try {
            NewClass1 p = new NewClass1();
            p.f();
        } catch (OpenException5 e) {
            throw new RuntimeException(e);
        } catch (NewException5 e) {
            throw new RuntimeException(e);
        }
    }
}