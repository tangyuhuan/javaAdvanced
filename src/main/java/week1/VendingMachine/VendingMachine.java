package week1.VendingMachine;

//自动售货机
//对象变量是对象的管理者
public class VendingMachine {
    int price = 70;//定价
    int balance = f();//现在你投入的钱，余额
    int total;//总收入

    int f(){
        return 10;
    }
    VendingMachine()//构造函数：名字和类名完全相同，不能有返回类型
    {
        total = 0;
    }
    VendingMachine(int price)//有参数的构造函数：名字和类名完全相同，不能有返回类型
    {
        this();//通过this调用无参构造函数,这种写法只能在构造函数里出现、只能第一句、只能使用一次
        this.price = price;
    }

    void setPrice(int price){
        //通过this.price访问到成员变量price
        this.price = price;
    }
    void showPrompt(){
        System.out.println("Welcome");
    }
    void insertMoney(int amount){
        balance = balance + amount;
        //在一个成员函数内部，调用另一个成员函数，直接调用就可以：即可以直接调用自己（this）的其他函数
        showBalance();
    }
    void showBalance(){
        //this是成员函数的一个特殊的固有的本地变量，表示这一次调用函数的对象
        //函数中可以直接写成员变量的名字来访问成员变量，下面两个写法等价
        System.out.println(balance);
//        System.out.println(this.balance);
    }
    void getFood(){
        if(balance >= price){
            System.out.println("Here u are");
            balance = balance - price;
            total = total + price;
        }
    }
    public static void main(String[] args){
        VendingMachine vm = new VendingMachine();
        vm.showPrompt();
        vm.showBalance();
        vm.insertMoney(100);
        vm.getFood();

        VendingMachine vm1 = new VendingMachine(100);
        vm1.insertMoney(200);
        System.out.println(vm1.price);
        vm.showBalance();
        vm1.showBalance();

    }
}
