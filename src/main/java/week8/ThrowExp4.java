package week8;
//子类不能声明抛出比父类的版本更多的异常
class OpenException4 extends Exception { }
class CLoseException4 extends OpenException4 { }
class NewException extends Exception {}
public class ThrowExp4 {
    public void f() throws OpenException4 {}
    public static void main(String[] args) {
    }
}
class NewClass extends ThrowExp4{
    //public void f() throws CLoseException4 {} //子类中声明抛出父类版本异常的子类是可以的
    public void f() throws OpenException4{}
//    public void f(){} //不抛出是可以的
    //public void f() throws OpenException4,NewException {} //子类不能声明抛出比父类的版本更多的异常，因为try catch的时候父类变量并不知道还有更多的异常
    //public void f() throws NewException {} //子类不能声明抛出比父类的版本更多的异常
    public static void main(String[] args) {
        ThrowExp4 p = new NewClass();//upcast向上造型，ThrowExp4类管理的是子类的对象
        //因为ThrowExp4的f()已经声明了会抛OpenException4，编译器会检查所有ThrowExp4 的f()是不是做了处理
        try {
            p.f();//抛出OpenException4
        } catch (OpenException4 e) {
            throw new RuntimeException(e);
        }
    }
}